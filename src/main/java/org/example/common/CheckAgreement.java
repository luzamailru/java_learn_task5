package org.example.common;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CheckAgreement implements Checkable{
    private final List<String> required = List.of ("number","openingDate");

    @Override
    public List<String> getRequired() {
        return required ;
    }
}
