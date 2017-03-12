package com.tsimura.db.repository.impl;

import com.tsimura.db.model.Post;
import com.tsimura.db.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static final String SQL_INSERT = "insert into posts (title, author_id, content) values (?, ?, ?)";
    private static final String SQL_FIND_BY_ID = "select id, title, author_id, content from posts where id = ?";
    private static final String SQL_FIND_BY_AUTHOR_ID = "select id, title, author_id, content from posts where author_id = ?";

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public void save(Post post) {
        jdbcTemplate.update(SQL_INSERT, post.getTitle(), post.getAuthorId(), post.getContent());
    }

    public Post findOne(long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID,
                new RowMapper<Post>() {
                    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Post post = new Post();
                        post.setId(rs.getLong(1));
                        post.setTitle(rs.getString(2));
                        post.setAuthorId(rs.getLong(3));
                        post.setContent(rs.getString(4));
                        return post;
                    }
                }, id);
    }

    public List<Post> findByAuthor(long authorId) {
        return jdbcTemplate.query(SQL_FIND_BY_AUTHOR_ID, new RowMapper<Post>() {
            public Post mapRow(ResultSet resultSet, int i) throws SQLException {
                Post post = new Post();
                post.setId(resultSet.getLong(1));
                post.setTitle(resultSet.getString(2));
                post.setAuthorId(resultSet.getLong(3));
                post.setContent(resultSet.getString(4));
                return post;
            }
        }, authorId);
    }
}
