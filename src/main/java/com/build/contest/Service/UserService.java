package com.build.contest.Service;

import com.build.contest.Entity.User;
import java.util.List;

public interface UserService {

    public User save(User user);
    public List<User> getUsers();
}
