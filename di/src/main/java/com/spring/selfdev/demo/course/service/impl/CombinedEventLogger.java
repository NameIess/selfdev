package com.spring.selfdev.demo.course.service.impl;

import com.spring.selfdev.demo.course.entity.Event;
import com.spring.selfdev.demo.course.service.EventLogger;

import java.util.List;

public class CombinedEventLogger implements EventLogger {
    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(eventLogger -> {
            eventLogger.logEvent(event);
        });
    }
}
