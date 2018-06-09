package com.spring.selfdev.demo.annotconf.helloworld.impl;

import com.spring.selfdev.demo.annotconf.helloworld.MessageProvider;
import com.spring.selfdev.demo.annotconf.helloworld.MessageRender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageRender")
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
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    @Resource(name = "messageProvider")
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
