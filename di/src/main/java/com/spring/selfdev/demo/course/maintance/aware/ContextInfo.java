package com.spring.selfdev.demo.course.maintance.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextInfo implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void printContextInfo() {
        System.out.println("Context id: " + applicationContext.getId());
        System.out.println("Application name: " + applicationContext.getApplicationName());
    }
}
