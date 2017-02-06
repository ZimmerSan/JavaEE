package com.tsimura.di;

import com.tsimura.di.model.Product;
import com.tsimura.di.model.Store;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ContextConfig.xml");

        Product banana = (Product) context.getBean("banana");
        System.out.println(banana.speak());

        Product potato = (Product) context.getBean("potato");
        System.out.println(potato.speak());

        Store poorStore = (Store) context.getBean("poorStore");
        System.out.println(poorStore.sell(potato));

        Store richStore = (Store) context.getBean("richStore");
        System.out.println(richStore.sell(banana));
    }
}
