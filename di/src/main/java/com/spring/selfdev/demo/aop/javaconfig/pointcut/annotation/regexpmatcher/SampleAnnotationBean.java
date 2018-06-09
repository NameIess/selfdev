package com.spring.selfdev.demo.aop.javaconfig.pointcut.annotation.regexpmatcher;

public class SampleAnnotationBean {
    @AdviceRequired
    public void foo(int x) {
        System.out.println("Invoked foo() with: " + x);
    }

    public void bar() {
        System.out.println("Invoked bar() ");
    }
}
