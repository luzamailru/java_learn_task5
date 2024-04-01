package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class InstanseAgreement {
    String generalAgreemetId; //    ID доп.Ген.соглашения
    String supplementaryAgreementId; // ID доп.соглашения
    ArrangementType arrangementType; //    Enum, НСО/ЕЖО/СМО/ДБДС и тд, см. актуальную ЛМД
    Long shedulerJobId; //Идентификатор задания/расписания     периодичность учета/расчета/выплаты фиксируется в поле name
    String number; //   Номер ДС
    Date openingDate; //    Дата заключения сделки (НСО/ЕЖО/СМО/ДБДС)
    Date closingDate; //
    Date cancelDate;
    Integer validityDuration;
    String cancellationReason;
    String status;//   Статус ДС: закрыт, открыт
    Date interestCalculationDate; //   Начисление начинается с (дата)
    Double interestRate; // Процент начисления на остаток
    Double  coefficient;// Показатель управления ставкой
    String coefficientAction; //    Повышающий/понижающий enum +/-
    Double    minimumInterestRate;//    Минимум по ставке
    Double  minimumInterestRateCoefficient;//   Коэффициент по минимальной ставке
    String minimumInterestRateCoefficientAction; //    Повышающий/понижающий enum +/-
    Double maximalnterestRate; //    Максимум по ставке
    Double maximalnterestRateCoefficient; //    Коэффициент по максимальной ставке
    String maximalnterestRateCoefficientAction; //    Повышающий/понижающий enum +/-


}
