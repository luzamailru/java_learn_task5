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
@Table(name="account_pool")
public class AccountPool {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "account_pool_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    Long id;
    String branch_code;
    String currency_code;
    String mdm_code;
    String priority_code;
    String registry_type_code;
}
