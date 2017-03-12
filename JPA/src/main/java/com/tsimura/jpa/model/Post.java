package com.tsimura.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;
}
