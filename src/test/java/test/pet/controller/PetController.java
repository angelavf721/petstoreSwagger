package test.pet.controller;

import org.junit.Test;
import test.pet.model.PetModel;

import java.io.File;

import static core.Utlis.getID;
import static core.Utlis.multipartReqSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PetController {

    private static Object idPet;

    @Test
    public void uploadImage() {
        Object id = getID();
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
        pet.setId_pet("9");
        given()
                .body(pet)
                .when()
                .put("/pet")
                .then()
                .statusCode(400);
    }

    //    não funciona
    @Test
    public void petNotFound() {
        PetModel pet = getPet();
        pet.setName("55552144458");
        pet.setStatus("55552144458");
        given()
                .body(pet)
                .when()
                .put("/pet")
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
    public void findsById() {
        Object id = getID();
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
        pet.setName("");
        pet.setId_pet("");
        pet.setStatus("");
        Object id = getID();
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
        pet.setId_pet(getID());
        pet.setName("fofito");
        pet.setStatus("available");
        return pet;
    }
}