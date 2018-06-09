package com.spring.selfdev.demo.aop.javaconfig.capture;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("Generic exception capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");         // перехват исключения IllegalArgumentException
        System.out.println("Caught: " + ex.getClass().getName());       //имя исключения
        System.out.println("Method: " + method.getName());              //имя метода
        System.out.println("***\n");
    }
}
