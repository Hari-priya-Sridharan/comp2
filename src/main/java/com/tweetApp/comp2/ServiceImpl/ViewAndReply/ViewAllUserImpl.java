package com.tweetApp.comp2.ServiceImpl.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.ViewAndReply.ViewAllUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewAllUserImpl implements ViewAllUserService {
    @Autowired
    UserRepo uRepo;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Override
    public ResponseEntity<?> viewAllUsers() {
        try{
            LOG.info("Fetching all users");
            List<User> users= uRepo.findAll();
            if(users.size()>0){
                LOG.info("Fetched Users :",users);
                return new ResponseEntity<>(users, HttpStatus.OK);
            }
            else{
                LOG.info("Fetched list of users is null");
                return new ResponseEntity<>("No users yet", HttpStatus.OK);
            }
        }
        catch (Exception e){
            throw new ErrorOccurred("fetching all the Users\n"+e);
        }

    }
}
