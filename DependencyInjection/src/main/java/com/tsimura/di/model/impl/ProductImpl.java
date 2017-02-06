package com.tsimura.di.model.impl;

import com.tsimura.di.model.Product;
import lombok.Data;

@Data
public abstract class ProductImpl implements Product {

    private int price;

    public ProductImpl(int price){
        this.price = Math.abs(price);
    }

    @Override
    public abstract String speak();
}
