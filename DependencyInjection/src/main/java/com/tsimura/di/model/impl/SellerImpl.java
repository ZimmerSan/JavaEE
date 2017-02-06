package com.tsimura.di.model.impl;

import com.tsimura.di.model.Product;
import com.tsimura.di.model.Seller;
import lombok.Data;

@Data
public class SellerImpl implements Seller {
    public static final String DEFAULT_NAME = "Bob";

    private String name;

    public SellerImpl(){
        this(DEFAULT_NAME);
    }

    public SellerImpl(String name){
        setName(name);
    }

    public int sell(Product product) {
        return product.getPrice();
    }

}
