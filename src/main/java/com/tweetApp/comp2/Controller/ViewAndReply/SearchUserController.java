package com.tweetApp.comp2.Controller.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.ViewAllUserImpl;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.searchUserImpl;
import com.tweetApp.comp2.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class SearchUserController {
    @Autowired
    searchUserImpl sService;
    private static final Logger log = LogManager.getLogger(regController.class.getName());
        @GetMapping("/user/search/{username}")
    public ResponseEntity<?> findUser(@PathVariable("username") String username){
        log.info("Searching user{} ",username);
        return sService.findUser(username);
    }
}
