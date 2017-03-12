package com.tsimura.jpa;

import com.tsimura.jpa.model.Post;
import com.tsimura.jpa.model.User;
import com.tsimura.jpa.service.PostService;
import com.tsimura.jpa.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        post.setAuthor(user);
        postService.save(post);
    }
}
