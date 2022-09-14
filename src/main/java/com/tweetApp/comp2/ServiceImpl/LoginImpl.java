package com.tweetApp.comp2.ServiceImpl;


import com.tweetApp.comp2.Controller.regController;
import com.tweetApp.comp2.Exceptions.BadLoginCredentialsException;
import com.tweetApp.comp2.Exceptions.UnableToFetchUserException;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.LoginService;
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



    public ResponseEntity<String> authenticateUser(String username,String password) {
        try {
            LOG.info("Fetching user details");
            return new ResponseEntity<>(this.findByUsername(username).toString(),  HttpStatus.OK);
        } catch (Exception e) {
            throw new BadLoginCredentialsException();
        }

    }
    public User findByUsername(String username){
        try {
             User u= uRepo.findByEmail(username);
             u.setStatus(1);
             uRepo.save(u);
            LOG.info("Logged in successfully as {}",username);
             return u;
        }
        catch (Exception e) {
            throw new UnableToFetchUserException();
        }
    }
}
