package com.tweetApp.comp2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class User {

    @Id
    @GeneratedValue
    private int loginId;
    @Indexed(unique = true)
    private String email;
    private String firstName;
    private String lastName ;
    private Date dob;
    private String gender;
    private String password;
    private String confirmPassword;
    private String contactNum;
    private int status;

}