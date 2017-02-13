package com.tsimura.dia.model.impl;

import lombok.Data;

@Data
public class Potato extends ProductImpl {

    public static final int DEFAULT_PRICE = 3;

    public Potato(){
        this(DEFAULT_PRICE);
    }

    public Potato(int price) {
        super(price);
    }

    public String speak() {
        return "I'm just a potato. I wish i had been a banana :(";
    }

}
