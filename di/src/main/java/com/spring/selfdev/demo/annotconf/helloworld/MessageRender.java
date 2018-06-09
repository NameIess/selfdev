package com.spring.selfdev.demo.annotconf.helloworld;

public interface MessageRender {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();

}
