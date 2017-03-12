package com.tsimura.jpa.service;

import com.tsimura.jpa.model.Post;
import com.tsimura.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
