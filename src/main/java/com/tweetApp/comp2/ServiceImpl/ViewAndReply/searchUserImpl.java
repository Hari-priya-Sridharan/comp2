package com.tweetApp.comp2.ServiceImpl.ViewAndReply;

import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.ViewAndReply.searchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class searchUserImpl implements searchUserService {
    @Autowired
    UserRepo uRepo;

    @Override
    public ResponseEntity<?> findUser(String username) {
        try{

            List<User> users= uRepo.searchUser(username);
            System.out.println(users);
            if(users.size()>0){
                return new ResponseEntity<List<User>>(users, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<String>(HttpStatus.OK);
            }
        }
        catch (Exception e){
            throw new ErrorOccurred("searching user ");
        }
    }
}
