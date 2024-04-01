package org.example.requests;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.common.AdditionalProperty;
import org.example.common.Checkable;
import org.example.common.InstanseAgreement;
import org.example.common.OptionalAttribute;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data

public class RequestProduct
{
    Long instanceId;
    String productType;
    String productCode;
    String registerType;
    String mdmCode;
    String contractNumber;
    Date contractDate;
    String priority;
    Double interestRatePenalty;
    Double  minimalBalance;
    Double  thresholdAmount;
    String accountingDetails;
    String rateType; // enum, дифференцированная 0 /прогрессивная 1
    Double taxPercentageRate;
    Double  technicalOverdraftLimitAmount;//    Сумма лимита технического овердрафта
    Integer contractId; //    Ссылка на договор обслуживания счета
    String branchCode;//  Код отделения, не БИК
    String isoCurrencyCode; //   Трехсимвольный код валюты счета в стандарте ISO
    String urgencyCode; //   Всегда “00”
    Integer referenceCode; // идентификатор точки продаж, где можно осуществлять операции внесения
    AdditionalProperty additionalPropertiesVip;//   массив дополнительных признаков для сегмента КИБ(VIP), добавлять по мере необходимости? на сегодня могут быть переданы 2 пары ключ/значение:
    InstanseAgreement[] agreements;

}