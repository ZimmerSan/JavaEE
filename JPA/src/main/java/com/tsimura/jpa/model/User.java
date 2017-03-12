package com.tsimura.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

}
