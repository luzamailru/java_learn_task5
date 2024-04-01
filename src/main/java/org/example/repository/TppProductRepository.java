package org.example.repository;

import org.example.entity.TppProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TppProductRepository extends JpaRepository<TppProduct,Integer> {
    List<TppProduct> findByNumber(String number);

    TppProduct findById(Long instanceId);
}
