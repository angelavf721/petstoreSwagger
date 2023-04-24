package test.pet.model;

import test.hooks.Base;

public class PetModel extends Base {
    private Object id_pet;
    private String name;
    private String category_name;
    private String photo;
    private String tags_name;

    private String status;

    public Object getId_pet() {
        return id_pet;
    }

    public void setId_pet(Object id_pet) {
        this.id_pet = id_pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }
    public String getTags_name() {
        return tags_name;
    }

    public void setTags_name(String tags_name) {
        this.tags_name = tags_name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
