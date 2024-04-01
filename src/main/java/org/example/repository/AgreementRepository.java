package org.example.repository;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entity.Agreement;
import org.example.entity.TppProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {
    List<Agreement> findByNumber(String number);
}
