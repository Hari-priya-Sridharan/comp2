package com.tweetApp.comp2.Controller;


import com.tweetApp.comp2.DTO.LoginRequest;
import com.tweetApp.comp2.ServiceImpl.LoginImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    @Autowired
    LoginImpl lService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());

    @GetMapping(value = "/api/v1.0/tweets/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        LOG.info("user details are being fetched {} {}",username,password);
        return lService.authenticateUser(username,password);
    }
}
