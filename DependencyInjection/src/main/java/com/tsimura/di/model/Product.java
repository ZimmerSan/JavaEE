package com.tsimura.di.model;

/* I know that method getPrice is illogical for product itself
because the price is different in every store.
But since it is a training project, we can allow it here :)
 */

public interface Product {

    int getPrice();

    String speak();

}
