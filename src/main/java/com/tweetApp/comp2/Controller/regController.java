package com.tweetApp.comp2.Controller;


import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.ServiceImpl.RegisterImpl;
import com.tweetApp.comp2.ServiceImpl.SequenceGeneratorServiceImpl;
import com.tweetApp.comp2.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class regController {
    private static final Logger log = LogManager.getLogger(regController.class.getName());
    @Autowired
    RegisterImpl rService;
    @Autowired
    SequenceGeneratorServiceImpl sgService;
    @PostMapping(value="/api/v1.0/tweets/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        user.setLoginId(sgService.getNextSequence("customSequences"));
        log.info("user id is set as : ",user.getLoginId());
        user.setStatus(0);
        log.info("user status is set as non-logged");
        return rService.registerUser(user);
    }



}
