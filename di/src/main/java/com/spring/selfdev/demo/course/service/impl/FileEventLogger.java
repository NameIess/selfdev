package com.spring.selfdev.demo.course.service.impl;

import com.spring.selfdev.demo.course.entity.Event;
import com.spring.selfdev.demo.course.service.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private String encoding;
    private File file;

    public FileEventLogger(String fileName, String encoding) {
        this.fileName = fileName;
        this.encoding = encoding;
    }

    @Override
    public void logEvent(Event event) {
        try {
            String message = event.getMessage();

            FileUtils.writeStringToFile(file, message, encoding, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        this.file = new File(fileName);
        boolean writable = file.canWrite();
        if (!writable) {
            throw new IOException("Can not write file " + file.getName());
        }
    }
}
