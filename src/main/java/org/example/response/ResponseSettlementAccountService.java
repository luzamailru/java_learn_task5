package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class ResponseSettlementAccountService {
    private   HttpStatus status;
    private String answer;
}
