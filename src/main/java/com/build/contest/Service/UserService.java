package com.build.contest.Service;

import com.build.contest.CustomExceptions.UserNotFoundException;
import com.build.contest.Dto.UserDto;
import com.build.contest.Entity.User;
import java.util.List;

public interface UserService {

    public User save(User user);

    public List<UserDto> getUsers(); 
    public UserDto getUserById(String id) throws UserNotFoundException;

    public User updateUser(String id,Integer score) throws UserNotFoundException;

    public void deleteUser(String id) throws UserNotFoundException;
}
