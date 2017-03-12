package com.tsimura.db.service;

import com.tsimura.db.model.Post;
import com.tsimura.db.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public void save(Post post){
        repository.save(post);
    }

    public Post findOne(long id){
        return repository.findOne(id);
    }

    public List<Post> findByAuthorId(long authorId) {
        return repository.findByAuthor(authorId);
    }
}
