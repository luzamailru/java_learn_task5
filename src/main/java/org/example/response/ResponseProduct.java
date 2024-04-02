package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Setter
@Data
public class ResponseProduct {
    @AllArgsConstructor
    private class Result{
        String instanceID;
        List<String> registerId;
        List<String> supplementaryAgreementId;
    }
    private  Result data;
    private  String errorMessage;
    public ResponseProduct() {}


    public void  init(Integer instanceId, List<String> registerId, List<String> supplementaryAgreemetId){
        Result data = new Result(instanceId.toString(),registerId,supplementaryAgreemetId);
        this.data = data;
    }
}


