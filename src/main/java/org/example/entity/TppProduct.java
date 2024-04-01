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
    Integer id;
    Integer product_code_id;
    Long client_id;
    String type;
    String number;
    String priority;
    Date date_of_conclusion;
    Date start_date_timr;
    Date end_date_time;
    Long days;
    Double penalty_rate;
    Double nso;
    Double threshold_amount;
    String requisite_type;
    String interest_rate_type;
    Double tax_rate;
    String reasone_close;
    String state;
}
