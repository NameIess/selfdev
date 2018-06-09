package com.spring.selfdev.demo.annotconf.helloworld.impl;

import com.spring.selfdev.demo.annotconf.helloworld.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    private String message;

    @Autowired
    public HelloWorldMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
