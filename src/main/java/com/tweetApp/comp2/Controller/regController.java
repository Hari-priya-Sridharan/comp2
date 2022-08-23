package com.tweetApp.comp2.Controller;

import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.RegisterService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestController
public class regController {
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Autowired
    RegisterService rService;
    @PostMapping(value="/api/v1.0/tweets/register")
    public ResponseEntity<String> registerUser(User user){
        return rService.registerUSer(user);
    }

}
