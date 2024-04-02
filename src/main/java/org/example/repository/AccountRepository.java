package org.example.repository;

import org.example.entity.Account;
import org.example.entity.AccountPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value="select *from account where account_pool_id=?", nativeQuery = true)
    List<Account> findByAccountPoolId(int accountPoolId);

}
