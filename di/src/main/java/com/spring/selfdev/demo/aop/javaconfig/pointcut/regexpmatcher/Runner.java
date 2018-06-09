package com.spring.selfdev.demo.aop.javaconfig.pointcut.regexpmatcher;

import com.spring.selfdev.demo.aop.javaconfig.pointcut.staticmethodmatcher.SimpleAroundAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Runner {
    public static void main(String[] args) {
        AspectjExpBean target = new AspectjExpBean();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        AspectjExpBean proxy = (AspectjExpBean) pf.getProxy();
        proxy.fool();
        proxy.foo();
        proxy.bar();
    }
}
