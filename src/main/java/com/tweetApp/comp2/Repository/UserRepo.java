package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByEmail(String username);
}
