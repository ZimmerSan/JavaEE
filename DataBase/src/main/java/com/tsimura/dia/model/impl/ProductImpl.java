package com.tsimura.dia.model.impl;

import com.tsimura.dia.model.Product;
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
