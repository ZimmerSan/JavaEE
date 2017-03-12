package com.tsimura.db.repository;

import com.tsimura.db.model.Post;

import java.util.List;

public interface PostRepository {

    void save(Post post);
    Post findOne(long id);
    List<Post> findByAuthor(long authorId);

}
