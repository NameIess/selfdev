package com.spring.selfdev.demo.course.entity;

public class Client {
    private Long id;
    private String name;
    private String greeting;

    public Client() {
    }

    public Client(Long id, String name, String greeting) {
        this.id = id;
        this.name = name;
        this.greeting = greeting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
