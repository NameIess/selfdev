package com.spring.selfdev.demo.aop.javaconfig.beforeafter;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
