package com.tweetApp.comp2.ServiceImpl.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Exceptions.UserNotFoundException;
import com.tweetApp.comp2.Exceptions.UsernameExistsException;
import com.tweetApp.comp2.Repository.TweetRepo;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.ViewAndReply.UserTweetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserTweetImpl implements UserTweetService {
    @Autowired
    TweetRepo tRepo;
    @Autowired
    UserRepo uRepo;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Override
    public ResponseEntity<?> getUserTweets(String username) {
        try{
            LOG.info("Fetching all user tweets");
            if( uRepo.findByEmail(username)==null) {
                throw new UserNotFoundException("Username not found");
            }
            List<Tweet> tweets= tRepo.findAllByUsername(username);
            if(tweets.size()>0){
                LOG.info("Fetched User Tweets :",tweets);
                return new ResponseEntity<>(tweets, HttpStatus.OK);
            }
            else{
                LOG.info("Fetched list of tweets is null");
                return new ResponseEntity<>("No tweet yet by the user", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException e){
            throw e;
        }
        catch (Exception e){
            throw new ErrorOccurred("fetching all the Users\n"+e);
        }
    }

    @Override
    public ResponseEntity<String> postTweet(Tweet tweet) {
        try {
            String username = tweet.getUsername();
            LOG.info("adding new user with username {}", username);
            LOG.info("saving user details to the database");
            tweet.setTweetDateTime(String.valueOf(new Date()));
            tRepo.save(tweet);
            return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            LOG.error("adding user with username {} failed", tweet.getUsername());
            throw new ErrorOccurred(" adding user.");
        }
    }
}
