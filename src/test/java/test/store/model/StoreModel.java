package test.store.model;

public class StoreModel {
    private Object idStore;
    private Object petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;


    public Object getIdStore(Object id) {
        return idStore;
    }

    public void setIdStore(Object idStore) {
        this.idStore = idStore;
    }

    public Object getPetId() {
        return petId;
    }

    public void setPetId(Object petId) {
        this.petId = petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
