package com.tweetApp.comp2.ServiceImpl.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
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
    private static final Logger log = LogManager.getLogger(regController.class.getName());
    @Override
    public ResponseEntity<List<User>> viewAllUsers() {

        log.info("Fetching all users");
        List<User> users= uRepo.findAll();
        log.info("Fetched Users :",users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
