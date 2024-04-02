package org.example.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.exception.BusinessException;
import org.example.requests.RequestProduct;
import org.example.service.CorporateSettlementInstanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
    @AllArgsConstructor
    @RequestMapping("/corporate-settlement-instance")
    public class CorporateSettlementInstanceController {
        private final CorporateSettlementInstanceService corporateSettlementInstanceService;
        @PostMapping
        @RequestMapping("/create")
        public ResponseEntity<String> create(@Valid @RequestBody RequestProduct requestProduct) throws BusinessException {
                return corporateSettlementInstanceService.create(requestProduct);
        }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<String> businessExceptionHandler(BusinessException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(e.getMessageCode()));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String>  runtimeExceptionHandler(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }



    }


