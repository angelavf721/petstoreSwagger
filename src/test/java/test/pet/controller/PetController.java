package test.pet.controller;

import test.hooks.Base;
import org.junit.Test;
import test.pet.model.PetModel;

import java.io.File;

import static test.Utlis.Utlis.getIDPet;
import static test.Utlis.Utlis.multipartReqSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PetController extends Base {

    private static Object idPet;

    @Test
    public void uploadImage() {
        Object id = getIDPet();
        File file = new File("src/test/image/download.jpg");
        given(multipartReqSpec())
                .pathParam("id", id)
                .multiPart(file)
                .when()
                .post("/pet/{id}/uploadImage")
                .then()
                .statusCode(200);
    }

    @Test
    public void creatPet() {
        PetModel pet = getPet();
        given()
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }

    @Test
    public void invalidInput() {
        given()
                .when()
                .post("/pet")
                .then()
                .statusCode(405)
                .body("message", is("no data"));
    }

    @Test
    public void upadatePet() {
        PetModel pet = getPet();
        pet.setName("Lion");
        given()
                .body(pet)
                .when()
                .put("/pet")
                .then()
                .statusCode(200);
    }

    @Test
    public void validationException() {
        given()
                .when()
                .put("/pet")
                .then()
                .statusCode(405)
                .body("message", is("no data"));
    }

    //    não funciona
    @Test
    public void InvalidIDsupplied() {
        PetModel pet = getPet();
        pet.setId_pet(555521444);
        given()
                .when()
                .body(pet)
                .put("/pet")
                .then()
                .statusCode(400);
    }

    //    não funciona
    @Test
    public void petNotFound() {
        PetModel pet = getPet();
        given()
                .body(pet)
                .when()
                .put("/pet/55552144458")
                .then()
                .statusCode(404);
    }

    @Test
    public void findsByStatus() {
        given()
                .queryParam("status", "pending")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200);
    }
    @Test
    public void findsByStatusInvalid() {
        given()
                .queryParam("status", "abacaxi")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(400);
    }

    @Test
    public void findsById() {
        Object id = getIDPet();
        given()
                .pathParam("id", id)
                .when()
                .get("/pet/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePetID() {
        PetModel pet = getPet();
        pet.setName("fofi");
        Object id = getIDPet();
        given()
                .pathParam("id", id)
                .body(pet)
                .when()
                .post("/pet/{id}")
                .then()
                .statusCode(405);
    }

    @Test
    public void deletePetNotFound() {
        given()
                .when()
                .delete("/pet/1111111111")
                .then()
                .statusCode(404);
    }

    //    não funciona
    @Test
    public void deletePetInvalidID() {
        given()
                .when()
                .delete("/pet/92Çkhgd")
                .then()
                .statusCode(400);
    }


    private PetModel getPet() {
        PetModel pet = new PetModel();
        pet.setId_pet(getIDPet());
        pet.setName("fofito");
        pet.setStatus("available");
        return pet;
    }
}