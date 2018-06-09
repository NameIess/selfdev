package com.spring.selfdev.demo.annotconf.helloworld;

import com.spring.selfdev.demo.annotconf.helloworld.impl.HelloWorldMessageProvider;
import com.spring.selfdev.demo.annotconf.helloworld.impl.StandardOutMessageRender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageProvider messageProvider() {
        return new HelloWorldMessageProvider("Hello from Java class context config");
    }

    @Bean
    public MessageRender messageRender() {
        MessageRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(messageProvider());

        return messageRender;
    }
}
