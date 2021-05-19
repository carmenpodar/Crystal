package com.company.beauty;

public class Main {

    public static void main(String[] args) {
        Saloon saloon = new Saloon();
        Customer customer = new Customer("Test customer");

        Visit visit = customer.createVisit(saloon.getProductsDiscount());

        Product shampoo = new Product();
        shampoo.setName("shampoo");
        shampoo.setPrice(12.5);

        Product conditioner = new Product();
        conditioner.setName("conditioner");
        conditioner.setPrice(15.5);

        visit.addProduct(shampoo);
        visit.addProduct(conditioner);

        Service hairCut = new Service();
        hairCut.setName("hair cut");
        hairCut.setPrice(35.0);

        Service hairCleaning = new Service();
        hairCleaning.setName("hair cleaning");
        hairCleaning.setPrice(15.0);

        visit.addService(hairCut);
        visit.addService(hairCleaning);

        System.out.printf("Total price: %s", visit.getTotalPrice());

        customer.setMembershipType(MembershipType.SILVER);

        Visit secondVisit = customer.createVisit(saloon.getProductsDiscount());

        secondVisit.addProduct(shampoo);
        secondVisit.addProduct(conditioner);

        secondVisit.addService(hairCut);
        secondVisit.addService(hairCleaning);
        System.out.println("\n=======AFTER THREE MONTHS=======");
        System.out.printf("Total price: %s", secondVisit.getTotalPrice());
        System.out.println("\n=======TOTAL SPENT======");
        System.out.printf("Total spent: %s", customer.getTotalPaid());



    }
}
