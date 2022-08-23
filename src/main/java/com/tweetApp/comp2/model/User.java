package com.tweetApp.comp2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
public class User {
    @Id
    private int id;
    private String username;
    private String firstname;
    private String lastname ;
    private Date dob;
    private String gender;
    private String password;
    private String confirm_password;
    private int status;

    public User(int i, String s, String hari, String piya, int i1, String female, String password, String password1, int i2) {
    }

    public User() {

    }
}