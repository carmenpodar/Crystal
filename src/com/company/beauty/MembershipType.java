package com.company.beauty;

public enum MembershipType {

    NONE(0),

    PREMIUM(0.2),

    GOLD(0.15),

    SILVER(0.1);

    private double discount;

    private MembershipType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

}
