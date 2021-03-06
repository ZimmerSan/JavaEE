package com.tsimura.db.service;

import com.tsimura.db.model.User;
import com.tsimura.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void save(User user){
        repository.save(user);
    }

    public User findOne(long id){
        return repository.findOne(id);
    }

    List<User> findByUsername(String username){
        return repository.findByUsername(username);
    }

}
