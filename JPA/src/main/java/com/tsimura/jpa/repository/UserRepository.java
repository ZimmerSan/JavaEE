package com.tsimura.jpa.repository;


import com.tsimura.jpa.model.User;

public interface UserRepository {

    User save(User user);
    User findOne(long id);

}
