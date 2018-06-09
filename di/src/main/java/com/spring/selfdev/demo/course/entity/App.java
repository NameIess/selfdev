package com.spring.selfdev.demo.course.entity;

import com.spring.selfdev.demo.course.service.EventLogger;
import com.spring.selfdev.demo.course.service.impl.ConsoleEventLogger;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;
    private EventLogger defaultLogger = new ConsoleEventLogger();


    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public App(Client client, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.loggers = loggers;
    }

    public void logEvent(EventType eventType, Event event) {
        eventLogger = loggers.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultLogger;
        }

        eventLogger.logEvent(event);
    }
}
