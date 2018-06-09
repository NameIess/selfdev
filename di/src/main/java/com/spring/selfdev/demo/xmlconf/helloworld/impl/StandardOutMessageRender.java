package com.spring.selfdev.demo.xmlconf.helloworld.impl;

import com.spring.selfdev.demo.xmlconf.helloworld.MessageProvider;
import com.spring.selfdev.demo.xmlconf.helloworld.MessageRender;

public class StandardOutMessageRender implements MessageRender {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider != null) {
            System.out.println(messageProvider.getMessage());
        } else {
            throw new RuntimeException("No message provided declared");
        }
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
