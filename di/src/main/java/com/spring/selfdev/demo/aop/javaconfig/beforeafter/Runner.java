package com.spring.selfdev.demo.aop.javaconfig.beforeafter;

import org.springframework.aop.framework.ProxyFactory;

public class Runner {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();

//        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
        target.writeMessage();
        System.out.println("\n");
        proxy.writeMessage();
    }
}
