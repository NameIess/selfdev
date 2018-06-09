package com.spring.selfdev.demo.remoteproccessing.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "contact")
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private DateTime birthDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birth_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
