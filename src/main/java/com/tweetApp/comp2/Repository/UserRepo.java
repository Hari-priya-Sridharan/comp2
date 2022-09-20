package com.tweetApp.comp2.Repository;

import com.tweetApp.comp2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
<<<<<<< Updated upstream
=======
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
>>>>>>> Stashed changes

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
   User findByEmail(String username);
<<<<<<< Updated upstream
=======
   @Query("{ 'email':{$regex:?0,$options:'i'}}")
   public List<User> searchUser(String username);
>>>>>>> Stashed changes
}
