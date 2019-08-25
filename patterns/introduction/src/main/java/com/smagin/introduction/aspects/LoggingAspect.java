package com.smagin.introduction.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before("execution(* *transferAmount(..))")
    public void logBeforeTransfer(){
        System.out.println("LoggingAspect.logBeforeTransfer");
    }

    @After("execution(* *transferAmmount(..))")
    public void logAfterTransfer(){
        System.out.println("LoggingAspect.logAfterTransfer");
    }
}
