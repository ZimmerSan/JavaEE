package com.tsimura.db.repository;

import com.tsimura.db.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);
    User findOne (long id);

    List<User> findByUsername(String username);
}
