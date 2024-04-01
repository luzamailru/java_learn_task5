package org.example.common;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CheckProductRequest  implements Checkable {
    private final List<String> required = List.of("productType"
           ,"productCode"
            ,"registerType"
            ,"mdmCode"
            ,"contractNumber"
            ,"contractDate"
            ,"priority"
            ,"contractId"
            ,"branchCode"
            ,"isoCurrencyCode"
            ,"urgencyCode",
            "referenceCode"
    );

   @Override
    public List<String> getRequired() {
        return required;
    }

}
