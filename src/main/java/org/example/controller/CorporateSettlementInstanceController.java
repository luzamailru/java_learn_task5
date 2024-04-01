package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.requests.RequestProduct;
import org.example.service.CorporateSettlementInstanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @AllArgsConstructor
    @RequestMapping("/corporate-settlement-instance")
    public class CorporateSettlementInstanceController {
        private final CorporateSettlementInstanceService corporateSettlementInstanceService;
        @PostMapping
        @RequestMapping("/create")
        public ResponseEntity<String> create(@RequestBody RequestProduct requestProduct){
            try {
                return corporateSettlementInstanceService.create(requestProduct);
            }
            catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }


