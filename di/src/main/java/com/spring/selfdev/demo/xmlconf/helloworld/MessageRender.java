package com.spring.selfdev.demo.xmlconf.helloworld;

public interface MessageRender {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();

}
