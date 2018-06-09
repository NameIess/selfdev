package com.spring.selfdev.demo.aop.javaconfig.pointcut.controlflow;

import com.spring.selfdev.demo.aop.javaconfig.beforeafter.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Runner {

    private static final String METHOD_NAME = "test";

    public static void main(String[] args) {
        TestBean target = new TestBean();
        Pointcut pointcut = new ControlFlowPointcut(Runner.class, METHOD_NAME);     //  Включить в срез все методы объекта прокси,
                                                                                    //  который снабжен советом с использованием Advisоr,
                                                                                    //  соответствующего этому экземпляру
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        TestBean proxy = (TestBean) pf.getProxy();      // Попытка нормального вызова
        System.out.println("Trying normal invoke");
        proxy.foo();                                    // Попытка вызова из ControlFlowExample. test ()
        proxy.bar();
        System.out.println("Trying under Runner.test()");
        test(proxy);
    }

    private static void test(TestBean proxy) {
        proxy.foo();
        proxy.bar();
    }
}
