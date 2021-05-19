package com.company.beauty;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;

    private String phone;

    private MembershipType membershipType = MembershipType.NONE;

    private List<Visit> visits = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Visit createVisit(double productsDiscount) {
        Visit visit = new Visit(membershipType, productsDiscount);
        this.visits.add(visit);
        return visit;
    }

    public double getTotalPaid() {
        double total = 0;
        for(Visit visit: visits) {
            total+= visit.getTotalPrice();
        }
        return total;
    }
}
