package com.spring.selfdev.demo.aop.javaconfig.before;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SecurityBeforeAdvice implements MethodBeforeAdvice {
    private static final String CORRECT_NAME = "Alex";
    private SecurityManager securityManager;

    public SecurityBeforeAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedUser();

        if (user == null) {
            throw new SecurityException("No user authenticated");
        } else if (user.getName().equals(CORRECT_NAME)) {
            System.out.println("Logged successfully as " + user.getName());
        } else {
            throw new SecurityException("Logged as: " + user.getName() + ". Incorrect");
        }
    }
}
