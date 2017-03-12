package com.tsimura.jpa.service;

import com.tsimura.jpa.model.User;
import com.tsimura.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
