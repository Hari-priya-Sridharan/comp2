package com.tweetApp.comp2.service;

import com.tweetApp.comp2.model.User;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<String> registerUser(User User);
}
