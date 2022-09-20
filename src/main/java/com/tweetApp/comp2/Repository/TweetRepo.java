package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepo extends MongoRepository<Tweet, String> {

    List<Tweet> findByOrderByTweetDateTimeDesc();
}
