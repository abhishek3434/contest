package com.build.contest.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.build.contest.CustomExceptions.InvalidScoreException;
import com.build.contest.CustomExceptions.UserNotFoundException;
import com.build.contest.Dto.UserDto;
import com.build.contest.Entity.User;
import com.build.contest.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{ 

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User save(User user) {
        user.setScore(0);
        return userRepository.save(user);        
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> userArr = userRepository.findAll();
        List<UserDto> usersList = new ArrayList<>();

        for(User user:userArr){
            UserDto userDto = modelMapper.map(user,UserDto.class);
            userDto.setBadge(setBadgeBasedonScore(userDto.getScore()));

            usersList.add(userDto);
        }
        Collections.sort(usersList,(a,b)->b.getScore()-a.getScore());
        return usersList;
    }

    @Override
    public User updateUser(String id,Integer score) throws UserNotFoundException,InvalidScoreException {
        if(score<0 || score>100){
            throw new InvalidScoreException( "Please enter valid score.");
        }
        Optional<User> checkUser = userRepository.findById(id);
        if(!checkUser.isPresent()){
            throw new UserNotFoundException("User not found.");
        }
        User user = checkUser.get();
        user.setScore(score);
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDto getUserById(String id) throws UserNotFoundException {
        Optional<User> checkUser = userRepository.findById(id);
        if(!checkUser.isPresent()){
            throw new UserNotFoundException( "User not found.");
        }
        UserDto user = modelMapper.map(checkUser.get(),UserDto.class);
        user.setBadge(setBadgeBasedonScore(user.getScore()));

        return user; 
    }

    @Override
    public void deleteUser(String id) throws UserNotFoundException {
        Optional<User> checkUser = userRepository.findById(id);
        if(!checkUser.isPresent()){
            throw new UserNotFoundException("User not found.");
        }
        userRepository.deleteById(id);
    }

    public String  setBadgeBasedonScore(Integer score){
        if(score == null || score == 0){
            return "Score not updated";
        }
        if(score>=1 && score<=30){
            return "Code Ninja";
        }
        else if(score>30 && score<=60){
            return "Code Champ";
        }
        else if(score>60 && score <=100){
            return "Code Master";
        }
        else{
            return "";
        }
    }
    
}
