package com.spring.selfdev.demo.aop.javaconfig.pointcut.staticmethodmatcher;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Runner {
    public static void main(String[] args) {
        BeanOne one = new BeanOne();
        BeanTwo two = new BeanTwo();

        BeanOne proxyOne;
        BeanTwo proxyTwo;

        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new SimpleAroundAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(one);
        proxyOne = (BeanOne) pf.getProxy();
        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(two);
        proxyTwo = (BeanTwo) pf.getProxy();

        proxyOne.foo();
        proxyTwo.foo();

        proxyOne.bar();
        proxyTwo.bar();
    }
}
