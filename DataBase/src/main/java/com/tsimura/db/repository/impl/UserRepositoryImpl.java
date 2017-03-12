package com.tsimura.db.repository.impl;

import com.tsimura.db.model.User;
import com.tsimura.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_INSERT = "insert into users (username) values (?)";
    private static final String SQL_FIND_BY_ID = "select id, username from users where id = ?";

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public void save(User user) {
        jdbcTemplate.update(SQL_INSERT, user.getUsername());
    }

    public User findOne(long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID,
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getLong(1));
                        user.setUsername(rs.getString(2));
                        return user;
                    }
                }, id);
    }

}
