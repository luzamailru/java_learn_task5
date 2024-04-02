package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.exception.BusinessException;
import org.example.requests.RequestProductRegister;
import org.example.service.CorporateSettlementAccountService;
import org.example.response.ResponseSettlementAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/corporate-settlement-account")
public class CorporateSettlementAccountController {
    private final CorporateSettlementAccountService corporateSettlementAccountService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<String> create(@RequestBody RequestProductRegister requestProductRegister) throws BusinessException {

        ResponseSettlementAccountService responseSettlementAccountService =
                corporateSettlementAccountService.create(requestProductRegister.getInstanceID(),
                        requestProductRegister.getBranchCode(),
                        requestProductRegister.getRegistryTypeCode(),
                        requestProductRegister.getCurrencyCode(),
                        requestProductRegister.getPriorityCode(),
                        requestProductRegister.getMdmCode(),
                        requestProductRegister.getClientCode(),
                        requestProductRegister.getTrainRegion(),
                        requestProductRegister.getCounter(),
                        requestProductRegister.getSalesCode());
            return new ResponseEntity<>(responseSettlementAccountService.getAnswer(), responseSettlementAccountService.getStatus());

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