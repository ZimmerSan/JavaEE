package com.tsimura.dia.model;

public interface Store {

    int sell(Product product);

    void hire(Seller seller);
    Seller fire(Seller seller);

}
