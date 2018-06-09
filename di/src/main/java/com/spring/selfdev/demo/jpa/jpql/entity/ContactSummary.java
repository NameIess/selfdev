package com.spring.selfdev.demo.jpa.jpql.entity;

import java.io.Serializable;

public class ContactSummary implements Serializable {
    private String firstName;
    private String lastName;
    private String homeTelNumber;

    public ContactSummary(String firstName, String lastName, String homeTelNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTelNumber = homeTelNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeTelNumber() {
        return homeTelNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactSummary{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", homeTelNumber='").append(homeTelNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
