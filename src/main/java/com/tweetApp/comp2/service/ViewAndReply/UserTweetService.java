package com.tweetApp.comp2.service.ViewAndReply;

import org.springframework.http.ResponseEntity;

public interface UserTweetService {
    ResponseEntity<?> getUserTweets(String username);
}
