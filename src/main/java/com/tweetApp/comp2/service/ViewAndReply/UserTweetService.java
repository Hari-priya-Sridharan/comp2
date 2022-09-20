package com.tweetApp.comp2.service.ViewAndReply;

import com.tweetApp.comp2.DTO.Comment;
import com.tweetApp.comp2.model.Tweet;
import org.springframework.http.ResponseEntity;

public interface UserTweetService {
    ResponseEntity<?> getUserTweets(String username);

    ResponseEntity<String> postTweet(Tweet tweet);

    ResponseEntity<String> updateTweet(Tweet tweet);

    ResponseEntity<String> likeTweet(String username, int tweet);

    ResponseEntity<String> deleteTweet(String username, int tweetID);

    ResponseEntity<String> replyTweet(String username, int tweetID, Comment reply);
}
