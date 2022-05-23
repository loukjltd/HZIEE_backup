package com.example.fakewechatproject.domain;

import androidx.annotation.NonNull;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;


public class User extends DataSupport {
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
