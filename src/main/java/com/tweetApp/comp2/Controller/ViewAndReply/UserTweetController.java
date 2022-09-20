package com.tweetApp.comp2.Controller.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.UserTweetImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class UserTweetController {
    @Autowired
    UserTweetImpl uService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserTweets(@PathVariable("username") String username){
        LOG.info("Fetching tweets of user: {} ",username);
        return uService.getUserTweets(username);
    }
}
