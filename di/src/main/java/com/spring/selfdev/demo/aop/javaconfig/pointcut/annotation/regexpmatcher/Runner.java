package com.spring.selfdev.demo.aop.javaconfig.pointcut.annotation.regexpmatcher;

import com.spring.selfdev.demo.aop.javaconfig.pointcut.staticmethodmatcher.SimpleAroundAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Runner {
    public static void main(String[] args) {
        SampleAnnotationBean target = new SampleAnnotationBean();
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());

        ProxyFactory pf = new ProxyFactory();
//        pf.setProxyTargetClass(true); // force the use of CGLIB proxies
//        pf.setFrozen(true);           // force proxy to be immutable
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        SampleAnnotationBean proxy = (SampleAnnotationBean) pf.getProxy();
        proxy.foo(100);
        proxy.bar();
    }
}
