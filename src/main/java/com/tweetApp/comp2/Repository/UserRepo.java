package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
   User findByEmail(String username);

   @Query("{ 'email':{$regex:?0,$options:'i'}}")
   public List<User> searchUser(String username);


}
