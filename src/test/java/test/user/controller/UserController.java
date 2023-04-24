package test.user.controller;

import test.hooks.Base;
import org.junit.Test;
import test.user.model.UserModel;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserController extends Base {

    @Test
    public void getName(){
        UserModel user = getUser();
      Object name = given()
               .log().all()
                .body(user)
                .when()
                .post("/user")
                .then()
               .statusCode(200)
               .log().all()
                .extract().path("username");
        System.out.println(name);
    }

    @Test
    public void getUserName(){
        given()
        .when()
            .get("/user/Paula")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void UserNotFound(){
        given()
        .when()
            .get("/user/Ana")
        .then()
                .statusCode(404)
                .body("message",is("User not found"))
                .log().all();
    }
    @Test
    public void upadateUser(){
        UserModel user = getUser();
        user.setPhone("6158479643");
       given()
                .log().all()
                .body(user)
                .when()
                .put("/user/Paula")
                .then()
                .statusCode(200);
    }
    @Test
    public void upadateUserNotfound(){
       given()
                .log().all()
                .when()
                .put("/user/marg")
                .then()
                .statusCode(404)
                .log().all();
    }
    @Test
    public void deleteUser(){
       given()
                .when()
                .delete("/user/Paula")
                .then()
                .statusCode(404);
    }

    @Test
    public void creatUser(){
        UserModel user = getUser();
         given()
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(200);
    }
    @Test
    public void createWithList(){
        UserModel[] userList = new UserModel().generateUsers(2);
         given()
                .body(userList)
                .when()
                .post("/user/createWithList")
                .then()
                .statusCode(200);
    }
    @Test
    public void createWithArray(){
        UserModel[] users = new UserModel().generateUsers(2);
         given()
                .body(users)
                .when()
                .post("/user/createWithArray")
                .then()
                .statusCode(200);
    }

    @Test
    public void login(){
        Map<String, String> login  = new HashMap<>();
        login.put("email","paulaCosta@gmail.com");
        login.put("password","158743");
         given()
                .body(login )
                .when()
                .get("/user/login")
                .then()
                .statusCode(200);
    }
    @Test
    public void logout(){
         given()
                .when()
                .get("/user/logout")
                .then()
                .statusCode(200)
                 .body("message",is("ok"));
    }


    private UserModel getUser(){
        UserModel user = new UserModel();
        user.setId(552217522);
        user.setUsername("Paula");
        user.setFirstName("Almeida");
        user.setLastName("Costa");
        user.setEmail("paulaCosta@gmail.com");
        user.setPassword("158743");
        user.setPhone("888888885");
        user.setUserStatus("0");
        return user;
    }
}
