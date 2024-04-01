package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class ResponseSettlementAccountService {
    HttpStatus status;
    String answer;
    String errorMessage;
}
