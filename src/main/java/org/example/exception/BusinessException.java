package org.example.exception;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;

@Getter
public class BusinessException extends  Exception{
    private Integer messageCode;

    public BusinessException(String message, Integer messageCode) {
        super(message);
        this.messageCode = messageCode;
    }

}
