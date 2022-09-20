package com.tweetApp.comp2.service.ViewAndReply;

import org.springframework.http.ResponseEntity;

public interface getAllTweetService {
    public ResponseEntity<?> fetchAllTweets();
}
