package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.requests.RequestProductRegister;
import org.example.service.CorporateSettlementAccountService;
import org.example.response.ResponseSettlementAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/corporate-settlement-account")
public class CorporateSettlementAccountController {
    private final CorporateSettlementAccountService corporateSettlementAccountService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<String> create(@RequestBody RequestProductRegister requestProductRegister) {
        ResponseSettlementAccountService responseSettlementAccountService =
                corporateSettlementAccountService.create(Long.valueOf(requestProductRegister.getInstanceID()),
                        requestProductRegister.getBranchCode(),
                        requestProductRegister.getRegistryTypeCode(),
                        requestProductRegister.getCurrencyCode(),
                        requestProductRegister.getPriorityCode(),
                        requestProductRegister.getMdmCode(),
                        requestProductRegister.getClientCode(),
                        requestProductRegister.getTrainRegion(),
                        requestProductRegister.getCounter(),
                        requestProductRegister.getSalesCode());
        if (responseSettlementAccountService.getAnswer() == null) {
            return new ResponseEntity<>(responseSettlementAccountService.getAnswer(), responseSettlementAccountService.getStatus());
        } else
            return new ResponseEntity<>(responseSettlementAccountService.getErrorMessage(), responseSettlementAccountService.getStatus());

    }
}