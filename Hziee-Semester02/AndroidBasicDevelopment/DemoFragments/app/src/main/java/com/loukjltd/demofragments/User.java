package com.loukjltd.demofragments;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private int userPhoto;
    private String userPhone;
    private List<User> userFriends;

    public User(String userName, int userPhoto, String userPhone) {
        this.userName = userName;
        this.userPhoto = userPhoto;
        this.userPhone = userPhone;
        userFriends = new ArrayList<User>(0);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<User> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(List<User> userFriends) {
        this.userFriends = userFriends;
    }
}
