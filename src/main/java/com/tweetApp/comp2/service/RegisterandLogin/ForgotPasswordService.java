package com.tweetApp.comp2.service.RegisterandLogin;

import com.tweetApp.comp2.DTO.ForgotPasswordDTO;
import org.springframework.http.ResponseEntity;

public interface ForgotPasswordService {
    ResponseEntity<?> updatePassword(ForgotPasswordDTO pDTO);
}
