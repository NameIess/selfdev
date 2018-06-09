package com.spring.selfdev.demo.aop.javaconfig.pointcut.dynamicmethodmatcher;

public class SampleBean {

    public void foo(int x) {
        System.out.println("foo() invoked with: " + x);
    }

    public void bar() {
        System.out.println("Bar");
    }
}
