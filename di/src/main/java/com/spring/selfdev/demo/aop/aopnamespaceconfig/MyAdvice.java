package com.spring.selfdev.demo.aop.aopnamespaceconfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    public void runBeforeAdvice(JoinPoint joinPoint, int intValue) {
        if (intValue != 100) {
            System.out.println("Executing in Before Advice: " +
                    joinPoint.getSignature().getDeclaringTypeName() + " " +
                    joinPoint.getSignature().getName() +
                    " argument: " + intValue);
        }
    }

    public Object runAroundAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable {
        // Вывести информацию перед выполнением
        System.out.println("Before execution in Around Advice: " +
                pjp.getSignature().getDeclaringTypeName() +
                " " +
                pjp.getSignature().getName() +
                " argument: " + intValue);

        Object retVal = pjp.proceed();

        // Вывести информацию после выполнения
        System.out.println("After execution in Around Advice: " +
                pjp.getSignature().getDeclaringTypeName() +
                " " +
                pjp.getSignature().getName() +
                " argument: " + intValue);

        return retVal;
    }
}
