package com.tweetApp.comp2.service.RegisterandLogin;

import com.tweetApp.comp2.model.User;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<String> registerUser(User User);
}
