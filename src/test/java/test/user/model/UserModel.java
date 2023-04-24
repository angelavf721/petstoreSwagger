package test.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserModel {
    private Object id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String userStatus;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public UserModel[] generateUsers(Integer quantity) {
        List<UserModel> users = new ArrayList<UserModel>();
        Random rand = new Random();

        for (int i = 0; i < quantity; i++) {
           UserModel user = new UserModel();
           Integer userPasswd = rand.nextInt(999999);
           user.setId(i);
            user.setUsername("Paula" + i);
            user.setFirstName("Almeida" + i);
            user.setLastName("Costa" + i);
            user.setEmail("paulaCosta" + i + "@gmail.com");
            user.setPassword(userPasswd.toString());
            user.setPhone("888888885");
            user.setUserStatus("0");
            users.add(user);
        }

        UserModel[] result = users.toArray(new UserModel[users.size()]);
        return result;
    }

}