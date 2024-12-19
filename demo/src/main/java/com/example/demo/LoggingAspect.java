package com.example.demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut for all methods of all classes
    @Before("execution(* com.example.demo.SingerFileDao.*(..))")
    public void logBeforeMethod() {
        System.out.println("logging_aspect!");
    }
}