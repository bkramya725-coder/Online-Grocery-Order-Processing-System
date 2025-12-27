package com.examly.springapp.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLog{
    Logger logger =LoggerFactory.getLogger(AOPLog.class);
    @Before("execution(* com.examly.springapp.service.*.*(..))")
    public void beforeServiceMethod() {
        logger.info("Before method execution");
    }

    @After("execution(* com.examly.springapp.service.*.*(..))")
    public void afterServiceMethod() {
        System.out.println("After Service Method Execution");
        logger.info("After method execution");
    }
}

