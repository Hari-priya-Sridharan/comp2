package com.tweetApp.comp2.Exceptions;

public class ErrorOccurred extends RuntimeException {
    public ErrorOccurred(String message) {
        super(message);
    }
}
