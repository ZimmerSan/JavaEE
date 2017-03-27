package com.tsimura.jpa.repository.impl;

import com.tsimura.jpa.model.User;
import com.tsimura.jpa.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public User findOne(long id) {
        return entityManager.find(User.class, id);
    }

}
