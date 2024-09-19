package com.yaryy.SpringBootREST.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.yaryy.SpringBootREST.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object object = joinPoint.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken by : " + joinPoint.getSignature().getName() + " " + (end-start) + " ms");

        return object;
    }

}
