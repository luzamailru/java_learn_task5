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
    int id;
    int account_pool_id ;
    String account_number;
    boolean bussy;
}
