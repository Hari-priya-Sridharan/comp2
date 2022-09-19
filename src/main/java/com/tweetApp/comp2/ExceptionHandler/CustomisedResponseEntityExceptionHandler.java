package com.tweetApp.comp2.ExceptionHandler;

import com.tweetApp.comp2.Exceptions.BadLoginCredentialsException;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Exceptions.UsernameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String USERNAME_ALREADY_EXISTS_CREATE_NEW_ONE = "Username already exists, create new one";
    private static final String ERROR_OCCURRED = "An unknown error occurred while ";



    @ExceptionHandler(UsernameExistsException.class)
    public final ResponseEntity<ExceptionResponse> handleUsernameExistsException(UsernameExistsException ex,
                                                                                 WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), USERNAME_ALREADY_EXISTS_CREATE_NEW_ONE);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(BadLoginCredentialsException.class)
    public final ResponseEntity<ExceptionResponse> handleBadLoginCredentialsException(BadLoginCredentialsException ex,
                                                                                 WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,  HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ErrorOccurred.class)
    public final ResponseEntity<ExceptionResponse> handleErrorOccured(ErrorOccurred ex,
                                                                                      WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ERROR_OCCURRED+ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,  HttpStatus.TEMPORARY_REDIRECT);
    }

//    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
//    public final ResponseEntity<ExceptionResponse> handleConstraintViolationException(
//            javax.validation.ConstraintViolationException ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}