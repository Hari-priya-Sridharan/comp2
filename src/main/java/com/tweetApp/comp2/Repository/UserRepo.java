package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
}
