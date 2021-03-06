package com.spring.selfdev.demo.aop.javaconfig.intro;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {      // Mixin injects not only a behaviour inside an object but also a STATE (isModified field)

    private boolean isModified = false;
    private Map<Method, Method> methodCache = new ConcurrentHashMap<>();

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Nullable
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (!isModified) {
            if ((invocation.getMethod().getName().startsWith("set")) && (invocation.getArguments().length == 1)) {
                Method getter = getGetter(invocation.getMethod());
                if (getter != null) {
                    Object newVal = invocation.getArguments()[0];
                    Object oldVal = getter.invoke(invocation.getThis(), null);
                    if ((newVal == null) && (oldVal == null)) {
                        isModified = false;
                    } else if ((newVal == null) && (oldVal != null)) {
                        isModified = true;
                    } else if ((newVal != null) && (oldVal == null)) {
                        isModified = true;
                    } else {
                        isModified = (!newVal.equals(oldVal));
                    }

                }
            }
        }

        return super.invoke(invocation);
    }


    private Method getGetter(Method setter) {
        Method getter = methodCache.get(setter);
        if (getter != null) {
            return getter;
        }
        String getterName = setter.getName().replaceFirst("set", "get");
        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);
            methodCache.put(setter, getter);
            return getter;
        } catch (NoSuchMethodException ex) {
            return null;
        }
    }
}


