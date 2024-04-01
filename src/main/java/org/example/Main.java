package org.example;

import com.google.gson.Gson;
import org.example.common.AdditionalProperty;
import org.example.common.ArrangementType;
import org.example.common.InstanseAgreement;
import org.example.common.OptionalAttribute;
import org.example.requests.RequestProduct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        SpringApplication.run(Main.class);
//       OptionalAttribute attribute = new OptionalAttribute("counter","123","счетчик");
//        OptionalAttribute[] attributes = new OptionalAttribute[1];
//
//        InstanseAgreement instanseAgreement = new InstanseAgreement("65432231","54654", ArrangementType.ЕЖО,
//                45654, "987",new Date(),null, null, 15,"причина расторжения",
//                "открыт", null, null, null, null, null, null,
//                null, null, null, null);
//    InstanseAgreement[] instanseAgreements = new InstanseAgreement[2];
//    instanseAgreements[0] = instanseAgreement;
//    instanseAgreements[1]=instanseAgreement;
//
//        attributes[0]=attribute;
//        RequestProduct requestProduct = new RequestProduct(
//               5,"2221","ДКО","123","9875456","DD123",new Date(),
//                0,20,100,
//                1000, "реквизиты выплаты", "0",15, 0, 456, "Код отделения","810","00",987654,
//                null,instanseAgreements);
//
//        Gson gson= new Gson();
//       System.out.println(gson.toJson(requestProduct));

    }
}