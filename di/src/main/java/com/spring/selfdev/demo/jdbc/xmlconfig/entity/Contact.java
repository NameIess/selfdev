package com.spring.selfdev.demo.jdbc.xmlconfig.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<ContactDetail> contactDetailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<ContactDetail> getContactDetailList() {
        return contactDetailList;
    }

    public void setContactDetailList(List<ContactDetail> contactDetailList) {
        this.contactDetailList = contactDetailList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", contactDetailList=").append(contactDetailList);
        sb.append('}');
        return sb.toString();
    }
}
