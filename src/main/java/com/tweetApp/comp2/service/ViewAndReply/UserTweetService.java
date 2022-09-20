package com.tweetApp.comp2.service.ViewAndReply;

import com.tweetApp.comp2.model.Tweet;
import org.springframework.http.ResponseEntity;

public interface UserTweetService {
    ResponseEntity<?> getUserTweets(String username);

    ResponseEntity<String> postTweet(Tweet tweet);

    ResponseEntity<String> updateTweet(Tweet tweet);

    ResponseEntity<String> deleteTweet(Tweet tweet);

    ResponseEntity<String> likeTweet(String username, Tweet tweet);
}
