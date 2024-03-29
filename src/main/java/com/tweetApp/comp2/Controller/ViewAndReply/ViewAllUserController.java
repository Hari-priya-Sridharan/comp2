package com.tweetApp.comp2.Controller.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.ViewAllUserImpl;
import com.tweetApp.comp2.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1.0/tweets")
public class ViewAllUserController {
    @Autowired

    ViewAllUserImpl vService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @GetMapping("/users/all")
    public ResponseEntity<?> getAllUsers(){
        LOG.info("Got all users");
        return vService.viewAllUsers();
    }
}
