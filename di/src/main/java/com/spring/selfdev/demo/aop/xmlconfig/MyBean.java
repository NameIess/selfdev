package com.spring.selfdev.demo.aop.xmlconfig;

public class MyBean {
    private MyDependency myDependency;

    public void execute() {
        myDependency.bar();
        myDependency.foo();
    }

    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
