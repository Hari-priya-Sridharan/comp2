package com.tweetApp.comp2.service.RegisterandLogin;

import com.tweetApp.comp2.model.User;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<String> authenticateUser(String username,String password);
    User findByUsername(String username);
}
