package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.entity.ProductRegister;
import org.example.entity.TppProduct;
import org.example.repository.ProductRegisterRepository;
import org.example.repository.RefProductRegisterTypeRepository;
import org.example.repository.TppProductRepository;
import org.junit.Before;
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

import static io.restassured.RestAssured.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCorporateSettlementAccountController {
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
    void testGetErrorWithoutInstanceID(){
        String jsonString ="{\"registryTypeCode\":\"03.012.002_47533_ComSoLd\",\"currencyCode\":\"800\"}";
         given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post("/corporate-settlement-account/create")
                .then().statusCode(400);
    }
    @Test
    void testGetErrorDoubleInstance() {
        ProductRegister productRegister = new ProductRegister((Integer) null, 26,	"03.012.002_47533_ComSoLd",	1L,	"800",	"OPEN","4761");
        productRegisterRepository.save(productRegister );

        String jsonString = "{\"instanceID\": 26,\"registryTypeCode\":\"03.012.002_47533_ComSoLd\"}";
        given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post("/corporate-settlement-account/create")
                .then().statusCode(400);
    }
    @Test
    void testGetErrorNotFoundProductCode() {
        ProductRegister productRegister = new ProductRegister((Integer) null, 26,	"03.012.002_47533_ComSoLd",	1L,	"800",	"OPEN","4761");
        productRegisterRepository.save(productRegister );
        System.out.println(refProductRegisterTypeRepository.findAll());

        String jsonString = "{\"instanceID\": 266,\"registryTypeCode\":\"03.012.002_47533_ComSoLd***\"}";
        given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post("/corporate-settlement-account/create")
                .then().statusCode(404);
    }


@Test
    void testGetErrorDProductCreated() {

        String jsonString ="{\"instanceID\": 2226,\"registryTypeCode\":\"03.012.002_47533_ComSoLd\",\"currencyCode\":\"800\",\"branchCode\":\"0022\"," +
                "\"priorityCode\":\"00\",\"mdmCode\":\"789465\",\"clientCode\":\"333\",\"trainRegio\":\"64\",\"counter\":\"666\"}";
    System.out.println(refProductRegisterTypeRepository.findAll());
        given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post("/corporate-settlement-account/create")
                .then().statusCode(200);
    }
}
