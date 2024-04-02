package org.example.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.common.AdditionalProperty;
import org.example.common.InstanseAgreement;

import java.util.*;

@Data
public class RequestProduct
{
    private Long instanceId;
    @Valid
    @NotNull(message = "productType должно быть заполнено")
    @NotBlank(message = "productType должно быть заполнено")
    private String productType;
    @Valid
    @NotNull(message = "productCode должно быть заполнено")
    @NotBlank(message = "productCode должно быть заполнено")
    private String productCode;
    @Valid
    @NotNull(message = "registerType; должно быть заполнено")
    @NotBlank(message = "registerType;должно быть заполнено")
    private String registerType;
    @Valid
    @NotNull(message = "registerType; должно быть заполнено")
    @NotBlank(message = "registerType;должно быть заполнено")
    private String mdmCode;
    @Valid
    @NotNull(message = "registerType; должно быть заполнено")
    @NotBlank(message = "registerType;должно быть заполнено")
    private String contractNumber;
    @Valid
    @NotNull(message = "registerType должно быть заполнено")
    private Date contractDate;
    @Valid
    @NotNull(message = "priority должно быть заполнено")
    @NotBlank(message = "priority должно быть заполнено")
    private String priority;
    private Double interestRatePenalty;
    private Double  minimalBalance;
    private Double  thresholdAmount;
    private String accountingDetails;
    private String rateType; // enum, дифференцированная 0 /прогрессивная 1
    private Double taxPercentageRate;
    private Double  technicalOverdraftLimitAmount;//    Сумма лимита технического овердрафта
    @Valid
    @NotNull(message = "contractId должно быть заполнено")

    private Integer contractId; //    Ссылка на договор обслуживания счета
    @Valid
    @NotNull(message = "branchCode должно быть заполнено")
    @NotBlank(message = "branchCode должно быть заполнено")
    private String branchCode;//  Код отделения, не БИК
    @Valid
    @NotNull(message = "isoCurrencyCode должно быть заполнено")
    @NotBlank(message = "isoCurrencyCode должно быть заполнено")
    private String isoCurrencyCode; //   Трехсимвольный код валюты счета в стандарте ISO
    @Valid
    @NotNull(message = "urgencyCode должно быть заполнено")
    @NotBlank(message = "urgencyCode  должно быть заполнено")
    private String urgencyCode; //   Всегда “00”
    @Valid
    @NotNull(message = "referenceCode должно быть заполнено")

    private Integer referenceCode; // идентификатор точки продаж, где можно осуществлять операции внесения
    private AdditionalProperty additionalPropertiesVip;//   массив дополнительных признаков для сегмента КИБ(VIP), добавлять по мере необходимости? на сегодня могут быть переданы 2 пары ключ/значение:
    private InstanseAgreement[] agreements;

}