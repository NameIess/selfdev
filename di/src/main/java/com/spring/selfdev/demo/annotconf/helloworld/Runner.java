package com.spring.selfdev.demo.annotconf.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRender messageRender = ctx.getBean("messageRender", MessageRender.class);
        messageRender.render();
    }
}
