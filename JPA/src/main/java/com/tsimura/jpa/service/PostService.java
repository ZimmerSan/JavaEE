package com.tsimura.jpa.service;

import com.tsimura.jpa.model.Post;
import com.tsimura.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class PostService {

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    PostRepository repository;

    public void save(Post post) {
        DefaultTransactionDefinition defTD = new DefaultTransactionDefinition();
        defTD.setName("postTx");
        defTD.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = txManager.getTransaction(defTD);
        try {
            repository.save(post);
            txManager.commit(status);
        } catch (Exception e) {
            txManager.rollback(status);
        }
    }

    public Post findOne(long id) {
        return repository.findOne(id);
    }

}
