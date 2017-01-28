package com.tsimura.jspservlet.model;

import java.util.ArrayList;
import java.util.List;

public class CoffeeExpert {
    public List<String> getTypes(String type) {
        List<String> types = new ArrayList<>();
        if (type.equals("milky")) {
            types.add("latte");
            types.add("cappuccino");
        } else if (type.equals("froffy")) {
            types.add("latte");
            types.add("cappuccino");
            types.add("frappuccino");
        } else if (type.equals("icey")) {
            types.add("frappuccino");
        } else if (type.equals("strong")) {
            types.add("espresso");
            types.add("double espresso");
        } else {
            types.add("Vending Machine");
        }
        return types;
    }
}
