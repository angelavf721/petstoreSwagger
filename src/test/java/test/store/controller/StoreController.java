package test.store.controller;


import org.junit.Test;
import test.store.model.StoreModel;

import static core.Utlis.dataDiferencaDias;
import static core.Utlis.getID;
import static io.restassured.RestAssured.given;

public class StoreController {

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

    private StoreModel getStore(){
        StoreModel store = new StoreModel();
        store.setPetId(getID());
        store.setQuantity(1);
        store.setShipDate(dataDiferencaDias(1));
        store.setStatus(true);
        return store;
    }

}
