package com.tsimura.db.model;

import lombok.Data;

@Data
public class Post {

    private long id;
    private String title;
    private long authorId;
    private String content;

}
