package test.store.controller;


import test.hooks.Base;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import test.store.model.StoreModel;

import static org.hamcrest.CoreMatchers.is;
import static test.Utlis.Utlis.getIDPet;
import static io.restassured.RestAssured.given;


public class StoreController extends Base {

    Object id;
    @Before
    public void gerarId(){
       StoreModel store = getStore();
       id = given()
                .body(store)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract().path("id");
    }

    @Test
    public void pegarPedidoParaAnimal(){
        StoreModel store = getStore();
        given()
            .body(store)
        .when()
            .post("/store/order")
        .then()
            .statusCode(200);
    }
    @Test
    public void InventoryById(){
        given()
                .log().all()
                .pathParam("id",id)
        .when()
            .get("/store/order/{id}")
        .then()
                .log().all()
            .statusCode(200);
    }
    @Test
    public void InventoryByIdOrderNotFund(){
        given()
        .when()
            .get("/store/order/1A")
        .then()
            .statusCode(404);
    }

    @Test
    public void InventoryByStatus(){
        given()
        .when()
            .get("/store/inventory")
        .then()
            .statusCode(200);
    }
    @Test
    public void deleteInventory(){
        given()
            .pathParam("id",id)
        .when()
            .delete("/store/order/{id}")

        .then()
                .log().all()
            .statusCode(200);
    }
    @Test
    public void deleteInventoryOrderNotFound(){
        given()
        .when()
            .delete("/store/order/5")
        .then()
                .log().all()
            .statusCode(404)
                .body("message", is("Order Not Found"));
    }
    @Ignore
    public void deleteInventoryInvalidID(){
        given()
        .when()
            .delete("/store/order/9999654")
        .then()
                .log().all()
            .statusCode(400)
                ;
    }

    private StoreModel getStore(){
        StoreModel store = new StoreModel();
        store.setIdStore(id);
        store.setPetId(getIDPet());
        store.setQuantity(1);
        store.setShipDate("2023-04-11T00:09:03.620Z");
        store.setStatus("placed");
        return store;
    }

}
