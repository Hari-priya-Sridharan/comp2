package com.tweetApp.comp2.Controller.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.ServiceImpl.RegisterAndLogin.RegisterImpl;
import com.tweetApp.comp2.ServiceImpl.SequenceGeneratorServiceImpl;
import com.tweetApp.comp2.ServiceImpl.ViewAndReply.UserTweetImpl;
import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class UserTweetController {
    @Autowired
    UserTweetImpl uService;
    @Autowired
    SequenceGeneratorServiceImpl sgService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserTweets(@PathVariable("username") String username){
        LOG.info("Fetching tweets of user: {} ",username);
        return uService.getUserTweets(username);
    }


    @PostMapping(value="/{username}/add")
    public ResponseEntity<String> postTweet(@PathVariable("username") String username,@RequestBody Tweet tweet){
        tweet.setTweetId(sgService.getNextSequence("customSequences"));
        tweet.setUsername(username);
        LOG.info("user id is set as : ",tweet.getTweetId());
        LOG.info("user status is set as non-logged");
        return uService.postTweet(tweet);
    }
}
