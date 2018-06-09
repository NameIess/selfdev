package com.spring.selfdev.demo.propertyvalidator.local;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private String type;

    Gender(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
