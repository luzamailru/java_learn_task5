package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tpp_product")
public class TppProduct {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "tpp_product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer id;
    private Integer product_code_id;
    private Long client_id;
    private String type;
    private String number;
    private String priority;
    private Date date_of_conclusion;
    private Date start_date_timr;
    private Date end_date_time;
    private Long days;
    private Double penalty_rate;
    private Double nso;
    private  Double threshold_amount;
    private String requisite_type;
    private String interest_rate_type;
    private Double tax_rate;
    private String reasone_close;
    private String state;
}
