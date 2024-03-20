package com.build.contest.CustomExceptions;

public class UserNotFoundException extends Exception {
    
    public UserNotFoundException(String msg){
        super(msg);
    }
}
