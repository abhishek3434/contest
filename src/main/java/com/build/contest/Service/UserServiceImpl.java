package com.build.contest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.build.contest.Entity.User;
import com.build.contest.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{ 

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);        
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }
    
}
