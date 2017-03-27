package com.tsimura.jpa.service;

import com.tsimura.jpa.model.User;
import com.tsimura.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserService {

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    UserRepository repository;

    public void save(User user){
        DefaultTransactionDefinition defTD = new DefaultTransactionDefinition();
        defTD.setName("userTx");
        defTD.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = txManager.getTransaction(defTD);
        try {
            repository.save(user);
            txManager.commit(status);
        } catch (Exception e) {
            txManager.rollback(status);
        }
    }

    public User findOne(long id){
        return repository.findOne(id);
    }
}
