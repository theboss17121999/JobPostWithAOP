package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class-name.method-name(args)
    @Before("execution(* com.example.spring_boot_rest.Service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.example.spring_boot_rest.Service.JobService.getJob(..))")
    public void logMethodCallafter(JoinPoint jp){
        LOGGER.info("Method Called after " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.spring_boot_rest.Service.JobService.getJob(..))")
    public void logMethodCallError(JoinPoint jp){
        LOGGER.info("Method Called after error" + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.spring_boot_rest.Service.JobService.getJob(..))")
    public void logMethodCallReturn(JoinPoint jp){
        LOGGER.info("Method Called succcesfully" + jp.getSignature().getName());
    }


}
