package com.build.contest.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.build.contest.Entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User save(User user);
    
}
