package com.tsimura.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class Logger {

    @Before(value = "execution(* com.tsimura.aspect.Notebook.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logBefore() is running!");
        System.out.println("method : " + joinPoint.getSignature().getName());
        System.out.println("args : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("-------");
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter() is running!");
        System.out.println("method : " + joinPoint.getSignature().getName());
        System.out.println("-------");
    }

    @AfterReturning(pointcut = "execution(* com.tsimura.aspect.Notebook.getNotes(..))", returning = "res")
    public void logAfterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("logAfterReturning() is running!");
        System.out.println("method : " + joinPoint.getSignature().getName());
        System.out.println("result: " + res);
        System.out.println("-------");
    }

}
