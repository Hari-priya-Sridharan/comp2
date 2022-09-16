package com.tweetApp.comp2.service;

import com.tweetApp.comp2.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ViewAllUserService {
    ResponseEntity<List<User>> viewAllUsers();
}
