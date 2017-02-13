package com.tsimura.dia.model.impl;

import com.tsimura.dia.model.Product;
import com.tsimura.dia.model.Seller;
import com.tsimura.dia.model.Store;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Data
public class StoreImpl implements Store {
    private static final String DEFAULT_NAME = "Bob's fruits";
    private static final int DEFAULT_CASH = 1000;

    private String name;

    @Autowired
    private Seller seller;
    private Set<Product> products;
    private int cash;

    public StoreImpl() {
        this(DEFAULT_NAME);
    }

    public StoreImpl(String name) {
        this(name, DEFAULT_CASH);
    }

    public StoreImpl(String name, int cash) {
        this(name, cash, null);
    }

    public StoreImpl(String name, int cash, Seller seller) {
        this(name, cash, seller, new HashSet<Product>());
    }

    public StoreImpl(String name, int cash, Seller seller, Set<Product> products) {
        this.name = name;
        this.cash = cash;
        hire(seller);
        this.products = products;
    }

    public int sell(Product product) {
        if (seller != null) {
            int cash = 0;
            if(products.contains(product)) {
                cash = seller.sell(product);
                this.cash += cash;
            }
            return cash;
        } else {
            System.out.println("Hire someone first, please");
            return 0;
        }
    }

    public void hire(Seller seller) {
        if (this.seller != null) fire(this.seller);
        this.seller = seller;
    }

    public Seller fire(Seller seller) {
        if (this.seller.equals(seller)) {
            this.seller = null;
            return seller;
        }
        return null;
    }

}
