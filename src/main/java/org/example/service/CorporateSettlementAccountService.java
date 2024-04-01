package org.example.service;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.example.entity.Account;
import org.example.entity.ProductRegister;
import org.example.repository.AccountPoolRepository;
import org.example.repository.AccountRepository;
import org.example.repository.ProductRegisterRepository;
import org.example.repository.RefProductRegisterTypeRepository;
import org.example.response.ResponseProductRegister;
import org.example.response.ResponseSettlementAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor

public class CorporateSettlementAccountService {
    private final ProductRegisterRepository productRegisterRepository;
    private final RefProductRegisterTypeRepository refProductRegisterTypeRepository;
    private final AccountPoolRepository accountPoolRepository;
    private  final AccountRepository accountRepository;
    public ResponseSettlementAccountService create(Long instanceID,
                                                   String branchCode,
                                                   String registryTypeCode,
                                                   String currencyCode,
                                                   String priorityCode,
                                                   String mdmCode,
                                                   String clientCode,
                                                   String trainRegion,
                                                   String counter,
                                                   String salesCode){
       // System.out.println("Создаенм запись в регистре продуктов " + instanceID);

        Gson gson = new Gson();
        ResponseProductRegister responseProductRegister = new ResponseProductRegister();

        if (isEmpty(instanceID) || instanceID==0 )
        {
            responseProductRegister.errorMessage = "instanceID не заполнено";
           return  new ResponseSettlementAccountService( HttpStatus.BAD_REQUEST, null,gson.toJson(responseProductRegister));
           // return new ResponseEntity<String>(gson.toJson(responseProductRegister), HttpStatus.BAD_REQUEST);
        }

        List<Integer> countProductRegisters = productRegisterRepository.countAllByProductIdAndType( instanceID, registryTypeCode);
       // System.out.println(countProductRegisters);
        if (countProductRegisters.get(0) > 0)
        {
            responseProductRegister.errorMessage = "Параметр registryTypeCode тип регистра  <"
                    + registryTypeCode
                    + "> уже существует для ЭП с ID <" + instanceID + ">" ;
            return  new ResponseSettlementAccountService( HttpStatus.BAD_REQUEST, null,gson.toJson(responseProductRegister));
            //return new ResponseEntity<String>(gson.toJson(responseProductRegister), HttpStatus.BAD_REQUEST);
        }

        List<Integer> countProductRegisterType = refProductRegisterTypeRepository.countAllByValue(registryTypeCode);
        //System.out.println("Ищем код продукта " + registryTypeCode);
        if (countProductRegisterType.get(0) == 0)
        {
            responseProductRegister.errorMessage = "Код продукта (registryTypeCode) <"
                    + registryTypeCode
                    + " не найден в Каталоге продуктов"  ;
            return  new ResponseSettlementAccountService( HttpStatus.NOT_FOUND,null,gson.toJson(responseProductRegister));

          //  return new ResponseEntity<String>(gson.toJson(responseProductRegister), HttpStatus.NOT_FOUND);
        }

        List<Integer>  accountPoolIdList = accountPoolRepository.findByAllFields(branchCode,currencyCode,priorityCode,registryTypeCode);
        if (accountPoolIdList.size()==0)
        {
            responseProductRegister.errorMessage = "Счет с указанными критериями  (branchCode,cncyCodeurrencyCode,priorityCode,registryTypeCode) " +
                    "(" +  branchCode + " , " + priorityCode +" , " + priorityCode + "," + registryTypeCode +") не найдлен в каталоге счетов ";
            return  new ResponseSettlementAccountService(  HttpStatus.NOT_FOUND,null,gson.toJson(responseProductRegister));

        }

        int accountPoolId = accountPoolIdList.get(0);
        List<Account> accounts = accountRepository.findByPoolId(accountPoolId);
        if (accounts.size()==0)
        {
            responseProductRegister.errorMessage = "Счет с указанными критериями  не найдлен в каталоге счетов ";
            return  new ResponseSettlementAccountService(  HttpStatus.NOT_FOUND,null,gson.toJson(responseProductRegister));

          //  return new ResponseEntity<String>(gson.toJson(responseProductRegister), HttpStatus.NOT_FOUND);
        }

        long account_id = accounts.get(0).getId();
        String accountNumber = accounts.get(0).getAccount_number();

        ProductRegister  newProductRegister =
                productRegisterRepository.save(new ProductRegister( null,instanceID,registryTypeCode,account_id,currencyCode,"OPEN",accountNumber));
     //   System.out.println(newProductRegister);
        responseProductRegister.init(newProductRegister.getId());
        return  new ResponseSettlementAccountService(  HttpStatus.OK,gson.toJson(responseProductRegister), null);

       // return new ResponseEntity<String>(gson.toJson(responseProductRegister), HttpStatus.OK);
    }
}
