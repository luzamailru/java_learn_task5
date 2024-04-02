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
@Table(name="tpp_ref_product_register_type")
public class RefProductRegisterType {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "tpp_ref_product_register_type_internal_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer internal_id;
    private String value;
    private String register_type_name;
    private String product_class_code;
    private Date register_type_start_date;
    private Date register_type_end_date;
    private String account_type;
}
