package com.tweetApp.comp2.ServiceImpl;

import com.tweetApp.comp2.Controller.regController;
import com.tweetApp.comp2.Exceptions.UnableToAddNewUserException;
import com.tweetApp.comp2.Exceptions.UsernameExistsException;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Slf4j
public class RegisterImpl implements RegisterService {

    private static final Logger LOG = LogManager.getLogger(regController.class.getName());

    @Autowired
    UserRepo uRepo;

    @Override
    public ResponseEntity<String> registerUser(User user) {
        try {
            String username=user.getEmail();
            LOG.info("adding new user with username {}", username);
            Optional<User> existingUser = uRepo.findByEmail(username);
            LOG.info("checking whether there is an existing user with username {}", username);
            if (existingUser.isPresent()) {
                LOG.error("user with this username already exists");
                throw new UsernameExistsException(username);
            } else {
                log.info("saving user details to the database");
                uRepo.save(user);
                return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);

            }

        } catch (UsernameExistsException e) {
            throw e;
        }

        catch (Exception e) {
            log.error("adding user with username {} failed", user.getEmail());
            throw new UnableToAddNewUserException();
        }
    }
}
