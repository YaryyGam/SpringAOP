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

    @Around("execution(* com.yaryy.SpringBootREST.service.JobService.getAllJobs(..))")
    public void monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        joinPoint.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken " + (end-start) + " ms");
    }

}
