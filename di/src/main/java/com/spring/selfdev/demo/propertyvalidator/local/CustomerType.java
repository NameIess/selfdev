package com.spring.selfdev.demo.propertyvalidator.local;

public enum CustomerType {
    INDIVIDUAL("I"),
    CORPORATE("C");

    private String type;

    CustomerType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
