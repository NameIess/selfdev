package com.spring.selfdev.demo.aop.javaconfig.before;

import org.springframework.aop.framework.ProxyFactory;

public class Runner {

    private static final String VALID_NAME = "Alex";
    private static final String INVALID_NAME = "Dima";

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SecureBean bean = getSecureBean();

        securityManager.login(VALID_NAME);
        bean.writeSecureMessage();
        securityManager.logout();

        try {
            securityManager.login(INVALID_NAME);
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            securityManager.logout();
        }

    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();

        SecurityBeforeAdvice advice = new SecurityBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);

        SecureBean proxyBean = (SecureBean) proxyFactory.getProxy();
        return proxyBean;
    }
}
