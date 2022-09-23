package com.tweetApp.comp2.ServiceImpl.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Repository.TweetRepo;
import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.service.ViewAndReply.getAllTweetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getAllTweetImpl implements getAllTweetService {
    @Autowired
    TweetRepo tRepo;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Override
    public ResponseEntity<?> fetchAllTweets() {
        try{
            LOG.info("Fetching all tweets");
            List<Tweet> tweets=tRepo.findByOrderByTweetDateTimeDesc();
//            List<Tweet> tweets=tRepo.findAll(Sort.by(Sort.Direction.DESC, "tweetDateTime"));
            System.out.println(tweets);
            if(tweets.size()>0){
                LOG.info("Fetched Tweets : ",tweets);
                return new ResponseEntity<>(tweets, HttpStatus.OK);
            }
            else{
                LOG.info("Fetched list of tweet is null");
                return new ResponseEntity<>( HttpStatus.OK);
            }
        }
        catch (Exception e){
            throw new ErrorOccurred("fetching all the tweets\n"+e);
        }

    }
}
