package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepo extends MongoRepository<User, String> {
   User findByEmail(String username);
   @Query("{'email': /?username/}")
   public List<User> searchUser(String username);
}
