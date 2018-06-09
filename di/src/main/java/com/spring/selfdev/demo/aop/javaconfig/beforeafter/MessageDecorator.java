package com.spring.selfdev.demo.aop.javaconfig.beforeafter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Hello ");
        Object relVal = methodInvocation.proceed();
        System.out.println("!");
        return relVal;
    }
}
