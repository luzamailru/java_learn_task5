package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tpp_product_register")
public class ProductRegister {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "tpp_product_register_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    Integer id;
    Long product_id;
    String type;
    Long account;
    String currency_code;
    String state;
    String account_number;
}
