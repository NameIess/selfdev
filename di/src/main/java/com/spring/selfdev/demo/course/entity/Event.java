package com.spring.selfdev.demo.course.entity;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private Long id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", date=").append(dateFormat.format(date));
        sb.append('}');
        return sb.toString();
    }
}
