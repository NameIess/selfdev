package com.spring.selfdev.demo.aop.javaconfig.pointcut.dynamicmethodmatcher;

import com.spring.selfdev.demo.aop.javaconfig.pointcut.staticmethodmatcher.SimpleAroundAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Runner {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAroundAdvice());

        ProxyFactory pf = new ProxyFactory () ;
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        SampleBean proxy = (SampleBean)pf.getProxy();

        proxy.foo(1);
        proxy.foo(10);
        proxy.foo(100);
        proxy.bar();
        proxy.bar();
        proxy.bar();
    }
}
