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
    private Long id;
    private String branch_code;
    private String currency_code;
    private String mdm_code;
    private String priority_code;
    private String registry_type_code;
}
