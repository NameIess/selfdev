package com.spring.selfdev.demo.course.service.impl;

import com.spring.selfdev.demo.course.entity.Event;
import com.spring.selfdev.demo.course.service.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public ConsoleEventLogger() {
    }

    @Override
    public void logEvent(Event event) {
        System.out.println("Console logger: " + event);
    }
}
