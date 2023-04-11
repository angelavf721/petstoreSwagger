package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class Base {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        RequestSpecBuilder resSpec = new RequestSpecBuilder();
        resSpec.setContentType(ContentType.JSON);
        RestAssured.requestSpecification = resSpec.build();

        ResponseSpecBuilder resBulder = new ResponseSpecBuilder();
        resBulder.expectResponseTime(Matchers.lessThan(5000L));
        RestAssured.responseSpecification = resBulder.build();

//        RestAssured.requestSpecification.header("Authorization", "Bearer " + "special-key");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
