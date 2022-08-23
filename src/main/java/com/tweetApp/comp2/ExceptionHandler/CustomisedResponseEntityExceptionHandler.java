package com.tweetApp.comp2.ExceptionHandler;

import com.tweetApp.comp2.Exceptions.UnableToAddNewUserException;
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
    private static final String USERNAME_ALREADY_EXISTS_CREATE_NEW_ONE = "username already exists, create new one";
    private static final String AN_UNKNOWN_ERROR_OCCURED_WHILE_ADDING_NEW_USER = "an unknown error occured while adding new user";

    @ExceptionHandler(UnableToAddNewUserException.class)
    public final ResponseEntity<ExceptionResponse> handleUnableToAddNewUserException(UnableToAddNewUserException ex,
                                                                                     WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                AN_UNKNOWN_ERROR_OCCURED_WHILE_ADDING_NEW_USER);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.TEMPORARY_REDIRECT);
    }

    @ExceptionHandler(UsernameExistsException.class)
    public final ResponseEntity<ExceptionResponse> handleUsernameExistsException(UsernameExistsException ex,
                                                                                 WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), USERNAME_ALREADY_EXISTS_CREATE_NEW_ONE);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

//    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
//    public final ResponseEntity<ExceptionResponse> handleConstraintViolationException(
//            javax.validation.ConstraintViolationException ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}