package com.build.contest.CustomExceptions;

public class InvalidScoreException extends RuntimeException{
    public InvalidScoreException(String msg){
        super(msg);
    }
}
