package com.spring.selfdev.demo.aop.javaconfig.before;

public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String name) {
        threadLocal.set(new UserInfo(name));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedUser() {
        return threadLocal.get();
    }
}
