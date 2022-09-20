package com.tweetApp.comp2.Controller.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.ViewAllUserImpl;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.getAllTweetImpl;
import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.ViewAndReply.getAllTweetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/tweets/")
public class GetAllTweetsController {
    @Autowired
    getAllTweetImpl gService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @GetMapping("all")
    public ResponseEntity<?> getAllTweets(){
        LOG.info("Fetching all tweets");
        return gService.fetchAllTweets();
    }
}
