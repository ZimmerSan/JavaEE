package com.tsimura.jpa.repository.impl;

import com.tsimura.jpa.model.Post;
import com.tsimura.jpa.repository.PostRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Post save(Post post) {
        entityManager.persist(post);
        return post;
    }

    public Post findOne(long id) {
        return entityManager.find(Post.class, id);
    }

}
