package com.yaryy.SpringBootREST.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type,
    // class name,
    // method name,
    // args

                    // return type, class-name.method-name (args)
    @Before("execution(* com.yaryy.SpringBootREST.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method called" + " " +joinPoint.getSignature().getName());
    }

    @After("execution(* com.yaryy.SpringBootREST.service.JobService.getAllJobs(..)) || execution(* com.yaryy.SpringBootREST.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method Executed" + " " +joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.yaryy.SpringBootREST.service.JobService.getAllJobs(..)) || execution(* com.yaryy.SpringBootREST.service.JobService.getJob(..))")
    public void logMethodException(JoinPoint joinPoint){
        LOGGER.info("Method has some issues" + " " +joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.yaryy.SpringBootREST.service.JobService.getAllJobs(..)) || execution(* com.yaryy.SpringBootREST.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint joinPoint){
        LOGGER.info("Method Executed Successfully" + " " +joinPoint.getSignature().getName());
    }

}
