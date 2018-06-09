package com.spring.selfdev.demo.xmlconf.helloworld.impl;

import com.spring.selfdev.demo.xmlconf.helloworld.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    private static final String MESSAGE = "Hello world!";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
