package com.spring.selfdev.demo.xmlconf.beanlifecycle.beforeafter;

public class SimpleBean {
    private static final String DEFAULT_NAME = "Alex Nosko";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void init() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new RuntimeException("Уоu must set the age property of any beans of type. Age has not been set " + SimpleBean.class);
        }

        System.out.println("SimpleBean after init() by init-method in XML config " + toString());
    }

    public void destroy() {
        System.out.println("Bean SimpleBean has been destroyed by destroy-method in XML config");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SimpleBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
