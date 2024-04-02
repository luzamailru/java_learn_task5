package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="account")
public class Account {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private int id;
    private int account_pool_id ;
    private String account_number;
    private boolean bussy;
}
