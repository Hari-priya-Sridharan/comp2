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
@RequestMapping("/api/v1.0/tweets/{username}")
public class UserTweetController {
    @Autowired
    UserTweetImpl uService;
    @Autowired
    SequenceGeneratorServiceImpl sgService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @GetMapping("")
    public ResponseEntity<?> getUserTweets(@PathVariable("username") String username){
        LOG.info("Fetching tweets of user: {} ",username);
        return uService.getUserTweets(username);
    }


    @PostMapping(value="/add")
    public ResponseEntity<String> postTweet(@PathVariable("username") String username,@RequestBody Tweet tweet){
        tweet.setTweetId(sgService.getNextSequence("customSequences"));
        tweet.setUsername(username);
        LOG.info("Tweet id is set as : ",tweet.getTweetId());
        return uService.postTweet(tweet);
    }
    @PutMapping(value ="/update/{id}" )
    public ResponseEntity<String> updateTweet(@PathVariable("username") String username,@PathVariable("id") int tweetID,@RequestBody Tweet tweet){
        LOG.info("Updating the tweet");
        tweet.setTweetId(tweetID);
        tweet.setUsername(username);
        return uService.updateTweet(tweet);
    }
}
