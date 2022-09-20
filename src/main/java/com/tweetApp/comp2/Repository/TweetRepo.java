package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepo extends MongoRepository<Tweet, String> {

    List<Tweet> findByOrderByTweetDateTimeDesc();

    List<Tweet> findAllByUsername(String username);

    Tweet findByTweetId(int tweetID);

    void deleteByTweetId(int tweetId);
}
