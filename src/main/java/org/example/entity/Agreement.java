package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private Integer id;
    private Integer product_id;
    private String general_agreement_id;
    private ArrangementType arrangement_type;
    private Long sheduler_job_id;

    private String number;

    private Date opening_date;
    private Date closing_date;
    private Date cancel_date;
    private Integer validity_duration;
    private String cancellation_reason;
    private String status;
    private  Date interest_calculation_date;
    private Double interest_rate;
    private Double coefficient;
    private String coefficient_action;
    private Double  minimum_interest_rate;
    private Double minimum_interest_rate_coefficient;
    private String minimum_interest_rate_coefficient_action;
    private Double  maximal_interest_rate;
    private Double maximal_interest_rate_coefficient;
    private String maximal_interest_rate_coefficient_action;
}
