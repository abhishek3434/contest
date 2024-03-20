package com.build.contest.CustomExceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.build.contest.Dto.ApiError;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity handleUserNotFound(){
        
        return new ResponseEntity<>(new ApiError(400,"User not found",new Date()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = InvalidScoreException.class)
    public ResponseEntity handleInvalidScore(){
        
        return new ResponseEntity<>(new ApiError(400,"Please enter valid score (Score should be greater than 0 and less than eqaul to 100.)",new Date()),HttpStatus.BAD_REQUEST);
    }
}
