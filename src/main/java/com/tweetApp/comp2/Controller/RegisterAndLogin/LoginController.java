package com.tweetApp.comp2.Controller.RegisterAndLogin;


import com.tweetApp.comp2.DTO.LoginDTO;
import com.tweetApp.comp2.ServiceImpl.RegisterAndLogin.LoginImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1.0/tweets")
public class LoginController {
    @Autowired
    LoginImpl lService;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        LOG.info("user details are being fetched {} {}",username,password);
        return lService.authenticateUser(username,password);
    }
}
