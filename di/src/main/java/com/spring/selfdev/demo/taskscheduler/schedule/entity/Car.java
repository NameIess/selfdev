package com.spring.selfdev.demo.taskscheduler.schedule.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    private Long id;
    private String licensePlate;
    private String manufacturer;
    private DateTime manufactureDate;
    private int age;
    private int version;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "license_plate")
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "manufacture_date")
    public DateTime getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(DateTime manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", licensePlate='").append(licensePlate).append('\'');
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", manufactureDate=").append(manufactureDate);
        sb.append(", age=").append(age);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}
