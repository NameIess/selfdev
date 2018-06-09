package com.spring.selfdev.demo.aop.javaconfig.capture;

import org.springframework.aop.framework.ProxyFactory;

public class Runner {
    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(errorBean);
        pf.addAdvice(new SimpleThrowsAdvice());

        ErrorBean proxy = (ErrorBean) pf.getProxy();

        try {
            proxy.errorProneMethod();
        } catch (Exception ignored) {

        }

        try {
            proxy.otherErrorProneMethod();
        } catch (Exception ignored) {

        }
    }
}
