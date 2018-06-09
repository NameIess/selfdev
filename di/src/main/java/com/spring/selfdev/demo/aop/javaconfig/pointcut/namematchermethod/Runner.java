package com.spring.selfdev.demo.aop.javaconfig.pointcut.namematchermethod;

import com.spring.selfdev.demo.aop.javaconfig.pointcut.staticmethodmatcher.SimpleAroundAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class Runner {
    public static void main(String[] args) {
        NamedBean target = new NamedBean();

//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.addMethodName("foo");
//        pointcut.addMethodName("bar");
//        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAroundAdvice());
        advisor.addMethodName("foo");
        advisor.addMethodName("bar");

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        NamedBean proxy = (NamedBean) pf.getProxy();
        proxy.foo();
        proxy.foo(999);
        proxy.bar();
        proxy.yup();

    }
}
