package org.example.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class RequestProductRegister {
    Integer instanceID;
    String  registryTypeCode;
    String currencyCode;
    String branchCode;
    String priorityCode;
    String mdmCode;
    String clientCode;
    String trainRegion;
    String counter;
    String salesCode;
}
