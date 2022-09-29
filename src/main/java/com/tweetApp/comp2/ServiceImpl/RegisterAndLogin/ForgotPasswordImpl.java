package com.tweetApp.comp2.ServiceImpl.RegisterAndLogin;

import com.tweetApp.comp2.Config.KafkaConsumerConfig;
import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.DTO.ForgotPasswordDTO;
import com.tweetApp.comp2.Exceptions.BadLoginCredentialsException;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import com.tweetApp.comp2.service.RegisterandLogin.ForgotPasswordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordImpl implements ForgotPasswordService {
    @Autowired
    UserRepo uRepo;
    @Autowired
    private KafkaConsumerConfig consumer;

    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Override
    public ResponseEntity<?> updatePassword(ForgotPasswordDTO pDTO) {

        try {
            User user = uRepo.findByEmail(pDTO.getUsername());
            if (user.getContactNum().equalsIgnoreCase(pDTO.getContact())) {
                LOG.info("Contact details are verified.");
                user.setPassword(pDTO.getNewPassword());
                user.setConfirmPassword(pDTO.getNewPassword());
                LOG.info("Password changed successfully");
                consumer.consume("Password changed successfully");
                uRepo.save(user);
                return new ResponseEntity<>( HttpStatus.OK);
            }
            else{
                throw new BadLoginCredentialsException("Contact Details Mismatch");
            }
        } catch (BadLoginCredentialsException e) {
           throw e;
        }
        catch (Exception e){
            throw new ErrorOccurred("changing password");
        }
    }
}
