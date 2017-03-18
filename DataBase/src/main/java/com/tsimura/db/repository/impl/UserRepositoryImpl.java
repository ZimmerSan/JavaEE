package com.tsimura.db.repository.impl;

import com.tsimura.db.model.User;
import com.tsimura.db.repository.UserRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_INSERT = "insert into users (username) values (?)";

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        jdbcTemplate.update(SQL_INSERT, user.getUsername());
    }

    @Override
    public User findOne(long id) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("find user by id");
        query.setParameter("id", id);
        return (User) query.list().get(0);
    }

    @Override
    public List<User> findByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from User u where username=:username");
        query.setParameter("username", username);
        List<User> users = (List<User>) query.list();
        return users;
    }

}
