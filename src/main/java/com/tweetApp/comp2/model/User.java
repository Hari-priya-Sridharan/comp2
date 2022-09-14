package com.tweetApp.comp2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Document
public class User {

    @Id
    private int loginId;
    @Indexed(unique = true)
    private String email;
    private String firstname;
    private String lastname ;
    private Date dob;
    private String gender;
    private String password;
    private String confirmPassword;
    private String contactNumber;
    private int status;

    public User(int loginId, String email, String firstname, String lastname, Date dob, String gender, String password, String confirmPassword, String contactNumber, int status) {
        this.loginId = loginId;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.contactNumber = contactNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginId=" + loginId +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", status=" + status +
                '}';
    }

    public User() {

    }
}