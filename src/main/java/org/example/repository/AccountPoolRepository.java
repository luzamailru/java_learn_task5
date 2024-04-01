package org.example.repository;

import org.example.entity.AccountPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountPoolRepository extends JpaRepository<AccountPool,Long> {
    @Query(value="select id from account_pool where branch_code=? and currency_code=? and priority_code =? and registry_type_code=?", nativeQuery = true)
    List<Integer> findByAllFields(String branchCode, String currencyCode, String priorityCode, String registryTypeCode);

}
