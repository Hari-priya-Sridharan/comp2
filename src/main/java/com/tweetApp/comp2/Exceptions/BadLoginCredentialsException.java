package com.tweetApp.comp2.Exceptions;

public class BadLoginCredentialsException extends RuntimeException{
        private static final long serialVersionUID = -7676088894966093231L;

        public BadLoginCredentialsException(String message) {
            super(message);
        }

}
