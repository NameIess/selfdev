package com.spring.selfdev.demo.aop.javaconfig.pointcut.staticmethodmatcher;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    private static final String VALID_METHOD_NAME = "foo";

    @Override
    public boolean matches(Method method, @Nullable Class<?> aClass) {
        String methodName = method.getName();
        boolean isValid = methodName.equals(VALID_METHOD_NAME);
        return isValid;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == BeanOne.class;
            }
        };
    }
}
