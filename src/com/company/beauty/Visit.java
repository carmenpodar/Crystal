package com.company.beauty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Visit {

    private final List<Service> services = new ArrayList<>();

    private final List<Product> products = new ArrayList<>();

    private double totalPrice;

    private double productDiscount;

    private final MembershipType membershipType;

    private final Date date = new Date();

    public Visit(MembershipType membershipType, double productDiscount) {
        this.membershipType = membershipType;
        this.productDiscount = productDiscount;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(Product product) {
        this.products.remove(product);
    }

    public void addService(Service service) {
        this.services.add(service);
    }

    public void deleteService(Service service) {
        this.services.remove(service);
    }

    private void calculateTotalPrice() {
        totalPrice = getProductsTotalPrice() + getServicesTotalPrice();
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public Date getDate() {
        return date;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        if(totalPrice == 0) {
            calculateTotalPrice();
        }
        return totalPrice;
    }

    private double getProductsTotalPrice() {
        double totalProductsPrice = 0;
        for (Product product : products) {
            totalProductsPrice += product.getPrice();
        }
        return totalProductsPrice * (1 - productDiscount);
    }

    private double getServicesTotalPrice() {
        double totalServicesPrice = 0;
        for (Service service : services) {
            totalServicesPrice += service.getPrice();
        }
        return totalServicesPrice * (1 - membershipType.getDiscount());
    }
}
