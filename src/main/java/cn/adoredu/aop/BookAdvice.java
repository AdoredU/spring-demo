package cn.adoredu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BookAdvice {

    @Before(value = "execution(* cn.adoredu.aop.Book.*(..))")
    public void before() {
        System.out.println("前置增强");
    }

    @AfterReturning("execution(* *.*(..))")
    public void after() {
        System.out.println("后置增强");
    }

    @Around("execution(* *.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法之前");

        joinPoint.proceed();

        System.out.println("方法之后");
    }
}
