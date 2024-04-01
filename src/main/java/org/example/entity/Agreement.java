package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.ArrangementType;

import java.util.Date;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="agreement")
public class Agreement {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "agreement_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    Integer id;
    Integer product_id;
    String general_agreement_id;
    ArrangementType arrangement_type;
    Long sheduler_job_id;
    String number;
    Date opening_date;
    Date closing_date;
    Date cancel_date;
    Integer validity_duration;
    String cancellation_reason;
    String status;
    Date interest_calculation_date;
    Double interest_rate;
    Double coefficient;
    String coefficient_action;
    Double  minimum_interest_rate;
    Double minimum_interest_rate_coefficient;
    String minimum_interest_rate_coefficient_action;
    Double  maximal_interest_rate;
    Double maximal_interest_rate_coefficient;
    String maximal_interest_rate_coefficient_action;
}
