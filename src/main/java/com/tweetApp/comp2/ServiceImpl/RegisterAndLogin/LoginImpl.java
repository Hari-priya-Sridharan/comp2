package com.tweetApp.comp2.ServiceImpl.RegisterAndLogin;


import com.tweetApp.comp2.Config.KafkaConsumerConfig;
import com.tweetApp.comp2.Config.KafkaProducerConfig;
import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.Exceptions.BadLoginCredentialsException;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.RegisterandLogin.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class LoginImpl implements LoginService {
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Autowired
    UserRepo uRepo;
    @Autowired
    KafkaConsumerConfig consumer;


    public ResponseEntity<?> authenticateUser(String username, String password) {
        try {
            LOG.info("Fetching user details");
            User user=this.findByUsername(username);
            if(password.equals(user.getPassword())){
                user.setStatus(1);
                uRepo.save(user);
                consumer.consume("User logged in");
                return new ResponseEntity<>(user,  HttpStatus.OK);
            }
           else{
               throw new BadLoginCredentialsException("Invalid user details. Please check the input and try again");
            }
        } catch (BadLoginCredentialsException e) {
            throw e;
        }

    }
    public User findByUsername(String username){
        try {
             User u= uRepo.findByEmail(username);

            LOG.info("Fetched successfully as {}",username);
             return u;
        }
        catch (Exception e) {
            throw new ErrorOccurred("fetching user details.");
        }
    }
}
