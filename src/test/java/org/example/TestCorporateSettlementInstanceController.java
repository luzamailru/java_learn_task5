package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.example.entity.TppProduct;
import org.example.repository.ProductRegisterRepository;
import org.example.repository.RefProductRegisterTypeRepository;
import org.example.repository.TppProductRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import java.io.File;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCorporateSettlementInstanceController {

    @LocalServerPort
    private Integer port;

    @Autowired
    TppProductRepository tppProductRepo;
    @Autowired
    ProductRegisterRepository productRegisterRepository;
    @Autowired
    RefProductRegisterTypeRepository refProductRegisterTypeRepository;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @BeforeAll
    static void beforeAll(){
        postgres.start();
    }

    @AfterAll
    static void afterAll(){
        postgres.stop();
    }
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void setUp()
    {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    void testCheckRequired(){

        File json = new File("./src/test/files/newInstance1.json");
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/corporate-settlement-instance/create")
                .then().statusCode(400);
    }

    @Test
    void testCheckDoubles(){
        TppProduct tppProduct = new TppProduct(null,9875456,	2221l,	"1878" ,"18",null,null,null,null,null,null,null,null,null,null,null,null,null);

        File json = new File("./src/test/files/newInstance2.json");
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/corporate-settlement-instance/create")
                .then().statusCode(400);
    }
    @Test
    void testSuccess(){
        File json = new File("./src/test/files/newInstance3.json");
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/corporate-settlement-instance/create")
                .then().statusCode(200);
    }


}
