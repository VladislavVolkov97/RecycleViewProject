package com.vame_owl.recycleviewproject.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public  String id;
    public String password;
    public String email;

 
    public User() {

    }

    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }
}