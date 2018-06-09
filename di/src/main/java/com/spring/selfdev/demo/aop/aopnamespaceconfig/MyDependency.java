package com.spring.selfdev.demo.aop.aopnamespaceconfig;

public class MyDependency {
    public void foo(int intValue) {
        System.out.println("foo(int): " + intValue);
    }

    public void bar() {
        System.out.println("bar()");
    }
}
