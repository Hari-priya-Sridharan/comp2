package com.tweetApp.comp2.Controller.RegisterAndLogin;

import com.tweetApp.comp2.DTO.ForgotPasswordDTO;
import com.tweetApp.comp2.ServiceImpl.RegisterAndLogin.ForgotPasswordImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class ForgotPasswordController {
    @Autowired
    ForgotPasswordImpl fpService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());



    @GetMapping(value = "/{username}/forgot")
    public ResponseEntity<?> updatePassword(@PathVariable("username") String username, @RequestBody ForgotPasswordDTO pDTO) {
        pDTO.setUsername(username);
        LOG.info("Password change initiated");

        return fpService.updatePassword(pDTO);
    }
}
