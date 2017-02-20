package com.tsimura.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public  static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("ContextConfig.xml");

        Notebook notebook = (Notebook) context.getBean("notebook");
        notebook.addNote("Dear Diary...");
        List<String> notes = notebook.getNotes();
    }
}
