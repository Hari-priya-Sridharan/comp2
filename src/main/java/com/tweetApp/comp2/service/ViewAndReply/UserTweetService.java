package com.tweetApp.comp2.service.ViewAndReply;

import com.tweetApp.comp2.model.Tweet;
import org.springframework.http.ResponseEntity;

public interface UserTweetService {
    ResponseEntity<?> getUserTweets(String username);

    ResponseEntity<String> postTweet(Tweet tweet);
}
