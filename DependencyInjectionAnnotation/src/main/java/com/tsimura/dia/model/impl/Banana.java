package com.tsimura.dia.model.impl;

import lombok.Data;

@Data
public class Banana extends ProductImpl {

    public static final int DEFAULT_PRICE = 3;

    public Banana(){
        this(DEFAULT_PRICE);
    }

    public Banana(int price) {
        super(price);
    }

    public String speak() {
        return "I'm a nice big banana!";
    }

}
