package com.tweetApp.comp2.service.ViewAndReply;

import com.tweetApp.comp2.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface searchUserService {
    ResponseEntity<?> findUser(String username);

}
