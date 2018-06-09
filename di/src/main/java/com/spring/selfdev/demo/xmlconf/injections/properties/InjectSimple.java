package com.spring.selfdev.demo.xmlconf.injections.properties;

public class InjectSimple {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private long ageInSeconds;

    public InjectSimple(String name, int age, float height, boolean programmer, long ageInSeconds) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.programmer = programmer;
        this.ageInSeconds = ageInSeconds;
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
