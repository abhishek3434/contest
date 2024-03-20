package com.build.contest.Controller;
import com.build.contest.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.build.contest.CustomExceptions.UserNotFoundException;
import com.build.contest.Dto.UserDto;
import com.build.contest.Dto.UserScoreDto;
import com.build.contest.Entity.User;


@RestController
@RequestMapping("api/v1")
public class UsersController {
    @Autowired
    private UserService userService;
    
    final public static String USERENDPOINT = "/user";

    //           -------------------Register new user----------------------
    @PostMapping(USERENDPOINT)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.save(user),HttpStatus.OK);
    }

    //           -------------------Get all users---------------------- 
    @GetMapping(USERENDPOINT)
    public  ResponseEntity<List<UserDto>> getUsers(){
        return new ResponseEntity<List<UserDto>>(userService.getUsers(), HttpStatus.OK);
    }

    //           -------------------Get specific user---------------------- 

    @GetMapping(USERENDPOINT+"/{id}")
    public  ResponseEntity<UserDto> getUsersById(@PathVariable String id) throws UserNotFoundException{
        return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.OK);
    }

    //           -------------------Update user score---------------------- 

    @PutMapping(USERENDPOINT+"/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody UserScoreDto user) throws UserNotFoundException{
        return new ResponseEntity<User>(userService.updateUser(id,user.getScore()),HttpStatus.OK);
    }

    @DeleteMapping(USERENDPOINT+"/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) throws UserNotFoundException{
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
