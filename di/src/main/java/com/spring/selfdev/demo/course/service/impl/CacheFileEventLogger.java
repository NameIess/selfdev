package com.spring.selfdev.demo.course.service.impl;

import com.spring.selfdev.demo.course.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String fileName, String encoding, int cacheSize) {
        super(fileName, encoding);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(event -> {
            System.out.println("Cached message: " + event.getMessage());
        });
    }

    private void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
