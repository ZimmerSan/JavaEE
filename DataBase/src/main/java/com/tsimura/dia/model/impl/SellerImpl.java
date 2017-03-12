package com.tsimura.dia.model.impl;

import com.tsimura.dia.model.Product;
import com.tsimura.dia.model.Seller;
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
