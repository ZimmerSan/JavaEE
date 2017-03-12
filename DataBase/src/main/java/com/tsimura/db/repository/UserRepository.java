package com.tsimura.db.repository;

import com.tsimura.db.model.User;

public interface UserRepository {

    void save(User user);
    User findOne (long id);

}
