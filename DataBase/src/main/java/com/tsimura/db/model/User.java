package com.tsimura.db.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Data
@Entity
@NamedQuery(query = "Select u from User u where u.id = :id", name = "find user by id")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;

}
