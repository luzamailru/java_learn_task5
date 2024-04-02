package org.example.service;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.example.common.*;
import org.example.entity.Agreement;
import org.example.entity.RefProductRegisterType;
import org.example.entity.TppProduct;
import org.example.exception.BusinessException;
import org.example.repository.*;
import org.example.requests.RequestProduct;
import org.example.response.ResponseProduct;
import org.example.response.ResponseProductRegister;
import org.example.response.ResponseSettlementAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor

public class CorporateSettlementInstanceService {
    private final ProductRegisterRepository productRegisterRepository;
    private final TppProductRepository productRepository;
    private final AgreementRepository agreementRepository;
    private final RefProductRegisterTypeRepository refProductRegisterTypeRepository;
    private final CorporateSettlementAccountService corporateSettlementAccountService;
    @Transactional
    public ResponseEntity<String> create(RequestProduct requestProduct) throws BusinessException {
        System.out.println(requestProduct);
        Gson gson = new Gson();
        ResponseProduct responseProduct = new ResponseProduct();
        TppProduct new_product = null;
        String validateResult;
        Boolean needCheck = true; // нужно проверять существование экземпляра product;
        ResponseSettlementAccountService resultProductRegister = null;
        List<String> agreementIds = new ArrayList<>();
        List<String> registerId = new ArrayList<>();

        //Если instanceId не задан
        if (requestProduct.getInstanceId()==null)
        {
            //Проверка на дубли в tpp_product
            List<TppProduct> findByNumber = productRepository.findByNumber(requestProduct.getContractNumber());
            System.out.println(findByNumber);
            if (findByNumber.size()>0) {
                throw  new BusinessException("Параметр ContractNumber № договора " + requestProduct.getContractNumber()
                        + " уже существует для ЭП id = " + findByNumber.get(0).getId(),400);
            }
            System.out.println("Проверка на дубли Agreement");
            //Проверка на дубли Agreement
            for (InstanseAgreement inst: requestProduct.getAgreements()
                 ) {
                List<Agreement> agreements = agreementRepository.findByNumber(inst.getNumber());
                if (agreements.size()>0) {
                   new BusinessException("Параметр number № дополнительного соглашения (сделки) " + inst.getNumber()
                           +  " уже существует для ЭП id = " + agreements.get(0).getId(),400);
                }
            }
            //по коду продукта найти связанные записи в каталоге Типа регистра
            List<RefProductRegisterType> refProductRegisterTypes
                    = refProductRegisterTypeRepository
                    .findAllByProductClassCodeAndAccountType(requestProduct.getProductCode(),"Клиентский");
            if (refProductRegisterTypes.size()==0) {
                new BusinessException("Код продукта  " + requestProduct.getProductCode()
                        + " не найден в каталоге продуктов ",404);
            }

            //Если дошлли сюда, создаем продукт
            TppProduct tppProduct = new TppProduct(
                    null,  //id
                    refProductRegisterTypes.get(0).getInternal_id(), //product_code_id
                    Long.parseLong(requestProduct.getMdmCode()), //client_id
                    requestProduct.getProductType(), //type;
                    requestProduct.getContractNumber(), //number
                    requestProduct.getPriority(), //priority
                    requestProduct.getContractDate(), //date_of_conclusion
                    requestProduct.getContractDate(), //start_date_timr
                    null,
                    null,  //days
                    requestProduct.getInterestRatePenalty(),
                    null, //nso
                    requestProduct.getThresholdAmount(), //threshold_amount;
                    null,
                    requestProduct.getRateType(), //requisite_type
                    requestProduct.getTaxPercentageRate(),
                    null,
                    "Открыт"
            );

            new_product = productRepository.save(tppProduct);
            needCheck = false;

            String counter=null;
            String trainRegion=null;

            for (OptionalAttribute op:requestProduct.getAdditionalPropertiesVip().getData()
                 ) {
                if (op.getKey()=="counter")
                { counter = op.getValue();}
                if   (op.getKey()=="trainRegion;")
                {trainRegion = op.getValue();}
            }
            try {
                resultProductRegister = corporateSettlementAccountService.create(
                        new_product.getId(),
                        requestProduct.getBranchCode(), //branchCode;
                        requestProduct.getRegisterType(), // registryTypeCode;
                        requestProduct.getIsoCurrencyCode(), // currencyCode;
                        requestProduct.getPriority(),// priorityCode;
                        requestProduct.getMdmCode(),
                        null, // clientCode;
                        trainRegion,   // trainRegion;
                        counter,
                        null);


                ResponseProductRegister responseProductRegister = gson.fromJson(resultProductRegister.getAnswer(), ResponseProductRegister.class);
                responseProductRegister.getAccountID();
                registerId.add(String.valueOf(responseProductRegister.getAccountID()));
            }
            catch (Exception exception){
                //Если добавление не состоялось, ничего страшного, просто вернем пустой список
            }
        }
       //Блок создания допсоглашений
        if (needCheck)
        {
            TppProduct productFindById = productRepository.findById(requestProduct.getInstanceId());
            new BusinessException("Экземпляр продукта  " + requestProduct.getInstanceId()
                    + " не найден в каталоге продуктов ",404);
        }


        //Если дошли сюда, создаем допсоглашения
        for (InstanseAgreement agr : requestProduct.getAgreements()
        ) {
            try {
                Agreement newAgreement = new Agreement(  null,
                new_product.getId(),  //product_id;
                agr.getGeneralAgreemetId(), //general_agreement_id;
                agr.getArrangementType(), // arrangment_type;
                agr.getShedulerJobId(),  //sheduler_job_id;
                agr.getNumber(),  //number;
                agr.getOpeningDate(), //opening_date;
                agr.getClosingDate(), // closing_date;
                agr.getCancelDate(), // cancel_date;
                agr.getValidityDuration(), //  validity_duration;
                agr.getCancellationReason(), //  cancellation_reason;
                agr.getStatus(),     //status;
                agr.getInterestCalculationDate(),        // interest_calculation_date;
                agr.getInterestRate(), //interest_rate;
                agr.getCoefficient(), // coefficient;
                agr.getCoefficientAction(), // coefficient_action;
                agr.getMinimumInterestRate(), //minimum_interest_rate;
                agr.getMaximalnterestRateCoefficient(),   //minimum_interest_rate_coefficient;
                agr.getMinimumInterestRateCoefficientAction(), // minimum_interest_rate_coefficient_action;
                agr.getMaximalnterestRate(), // maximum_interest_rate;
                agr.getMaximalnterestRateCoefficient(), //maximim_interest_rate_coefficient;
                agr.getMaximalnterestRateCoefficientAction() //maximum_interest_rate_coefficient_action;
                 );

                Agreement createdAgreement = agreementRepository.save(newAgreement);
                agreementIds.add(Long.valueOf(createdAgreement.getId()).toString());
                }
            catch (Exception e)
            {
                //Если добавление не состоялось, ничего страшного, просто вернем пустой список
                //Да, мне тоже странно, что не надо транзакцию откатывать
            }
        }
        //Здесь формируем ответ
        responseProduct.init(new_product.getId(),registerId,agreementIds  );

        return new ResponseEntity<String>(gson.toJson(responseProduct), HttpStatus.OK);
    }
}
