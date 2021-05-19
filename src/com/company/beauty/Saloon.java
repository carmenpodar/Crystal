package com.company.beauty;

import java.util.ArrayList;
import java.util.List;

public class Saloon {

    private List<Customer> customers = new ArrayList<>();

    private double productsDiscount = 0.1;

    public void setProductsDiscount(double productsDiscount) {
        this.productsDiscount = productsDiscount;
    }

    public double getProductsDiscount() {
        return productsDiscount;
    }
}
