package com.tsimura.jpa.repository;


import com.tsimura.jpa.model.Post;

public interface PostRepository {

    Post save(Post post);
    Post findOne(long id);

}
