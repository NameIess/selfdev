package com.spring.selfdev.demo.aop.javaconfig.pointcut.dynamicmethodmatcher;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static final String VALID_METHOD_NAME = "foo";

    @Override
    public boolean matches(Method method, @Nullable Class<?> aClass, Object... objects) {
        System.out.println("Dynamic check for " + method.getName());
        int x = (Integer) objects[0];
        boolean isValid = x != 100;
        return isValid;
    }

    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass) {     // Static check for optimisation. Spring invokes it first, before
                                                                                // dynamic check. If this method returns 'false', dynamic matches will not be called.
        System.out.println("Static check for " + method.getName());
        return method.getName().equals(VALID_METHOD_NAME);
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return (aClass == SampleBean.class);
            }
        };
    }
}
