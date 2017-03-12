package com.tsimura.db;

import com.tsimura.db.model.Post;
import com.tsimura.db.model.User;
import com.tsimura.db.service.PostService;
import com.tsimura.db.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ContextConfig.xml");

        PostService postService = context.getBean(PostService.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setUsername("Bob");
        userService.save(user);

        Post post = new Post();
        post.setId(0);
        post.setTitle("MyTitle");
        post.setContent("MyText");
        post.setAuthorId(user.getId());
        postService.save(post);

        Post one = postService.findOne(post.getId());
        List<Post> many = postService.findByAuthorId(user.getId());
    }
}
