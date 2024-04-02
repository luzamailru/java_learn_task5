package org.example.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class RequestProductRegister {
    private Integer instanceID;
    private String  registryTypeCode;
    private String currencyCode;
    private String branchCode;
    private String priorityCode;
    private String mdmCode;
    private String clientCode;
    private String trainRegion;
    private String counter;
    private String salesCode;
}
