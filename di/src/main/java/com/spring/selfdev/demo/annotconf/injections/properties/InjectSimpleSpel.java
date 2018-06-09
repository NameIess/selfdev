package com.spring.selfdev.demo.annotconf.injections.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {

    @Value("#{injectSimple.name}")
    private String name;

    @Value("#{injectSimple.age}")
    private int age;

    @Value("#{injectSimple.height}")
    private float height;

    @Value("#{injectSimple.programmer}")
    private boolean programmer;

    @Value("#{injectSimple.ageInSeconds}")
    private long ageInSeconds;

    public InjectSimpleSpel() {
    }

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
        final StringBuilder sb = new StringBuilder("InjectSimpleSpel{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", programmer=").append(programmer);
        sb.append(", ageInSeconds=").append(ageInSeconds);
        sb.append('}');
        return sb.toString();
    }
}
