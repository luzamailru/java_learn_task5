package org.example.repository;

import org.example.entity.ProductRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRegisterRepository extends JpaRepository<ProductRegister,Long> {
    @Query(value="select count(*) from tpp_product_register where product_id =? and type =?", nativeQuery = true)
    List<Integer>countAllByProductIdAndType(long productId, String type);
}
