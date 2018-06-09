package com.spring.selfdev.demo.annotconf.injections.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {

    @Value("Alex Nosko")
    private String name;

    @Value("21")
    private int age;

    @Value("183")
    private float height;

    @Value("true")
    private boolean programmer;

    @Value("1235745")
    private long ageInSeconds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InjectSimple{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", programmer=").append(programmer);
        sb.append(", ageInSeconds=").append(ageInSeconds);
        sb.append('}');
        return sb.toString();
    }
}
