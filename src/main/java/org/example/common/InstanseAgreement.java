package org.example.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class InstanseAgreement {
    private String generalAgreemetId; //    ID доп.Ген.соглашения
    private String supplementaryAgreementId; // ID доп.соглашения
    private ArrangementType arrangementType; //    Enum, НСО/ЕЖО/СМО/ДБДС и тд, см. актуальную ЛМД
    private Long shedulerJobId; //Идентификатор задания/расписания     периодичность учета/расчета/выплаты фиксируется в поле name
    @Valid
    @NotNull(message = "number (Agreement) должно быть заполнено")
    @NotBlank(message = "number (Agreement)  должно быть заполнено")
    private String number; //   Номер ДС
    @Valid
    @NotNull(message = "openingDate должно быть заполнено")
    private Date  openingDate; //    Дата заключения сделки (НСО/ЕЖО/СМО/ДБДС)
    private Date closingDate; //
    private Date cancelDate;
    private Integer validityDuration;
    private String cancellationReason;
    private String status;//   Статус ДС: закрыт, открыт
    private Date interestCalculationDate; //   Начисление начинается с (дата)
    private Double interestRate; // Процент начисления на остаток
    private Double  coefficient;// Показатель управления ставкой
    private String coefficientAction; //    Повышающий/понижающий enum +/-
    private Double    minimumInterestRate;//    Минимум по ставке
    private Double  minimumInterestRateCoefficient;//   Коэффициент по минимальной ставке
    private String minimumInterestRateCoefficientAction; //    Повышающий/понижающий enum +/-
    private Double maximalnterestRate; //    Максимум по ставке
    private Double maximalnterestRateCoefficient; //    Коэффициент по максимальной ставке
    private String maximalnterestRateCoefficientAction; //    Повышающий/понижающий enum +/-


}
