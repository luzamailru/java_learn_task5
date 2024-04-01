package org.example.repository;

import org.example.entity.RefProductRegisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RefProductRegisterTypeRepository extends JpaRepository<RefProductRegisterType, Long> {
    @Query(value="select count(*) from tpp_ref_product_register_type where value =?", nativeQuery = true)
    List<Integer> countAllByValue(String value);
    @Query(value="select * from tpp_ref_product_register_type where product_class_code=? and account_type=?", nativeQuery = true)
    List<RefProductRegisterType> findAllByProductClassCodeAndAccountType(String productClassCode, String accountType);

}
