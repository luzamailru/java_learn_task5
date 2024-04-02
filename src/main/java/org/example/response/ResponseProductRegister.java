package org.example.response;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
    @Setter
    @Data
    public class ResponseProductRegister {
        @AllArgsConstructor

        private class AccountID{
            int accountID;
        }
        private org.example.response.ResponseProductRegister.AccountID data;
        private String errorMessage;
        public ResponseProductRegister() {}


        public void  init(int accountId){
            org.example.response.ResponseProductRegister.AccountID data = new org.example.response.ResponseProductRegister.AccountID(accountId);
            this.data = data;
        }

        public String getAccountID() {
            Integer result = data.accountID;
            return result.toString();
        }
    }

