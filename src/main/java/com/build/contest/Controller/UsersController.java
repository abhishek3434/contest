package com.build.contest.Controller;
import com.build.contest.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.build.contest.Entity.User;


@RestController
@RequestMapping("api/v1")
public class UsersController {
    @Autowired
    private UserService userService;
    
    final public static String USERENDPOINT = "/user";

    @PostMapping(USERENDPOINT)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.save(user),HttpStatus.OK);
    }
    @GetMapping(USERENDPOINT)
    public  ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }
}
