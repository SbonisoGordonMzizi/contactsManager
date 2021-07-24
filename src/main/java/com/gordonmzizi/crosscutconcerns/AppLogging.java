package com.gordonmzizi.crosscutconcerns;

import com.gordonmzizi.businesslogic.Business;
import org.apache.log4j.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AppLogging {
    Logger logger = Logger.getLogger(Business.class);
    Layout layout = new PatternLayout("%p %d %c %M [%m] %n");
    Appender appender = new ConsoleAppender(layout);

    @Before("logerMainConfig()")
    public void viewContactsLogBefore(JoinPoint joinPoint){

        logger.addAppender(appender);
        logger.info("Start Executing "+joinPoint.getSignature());

    }

    @After("logerMainConfig()")
    public void viewContactsLogAfter(JoinPoint joinPoint){

        logger.addAppender(appender);
        logger.info("Done Executing "+joinPoint.getSignature());
    }
    @Pointcut("execution(public * com.gordonmzizi.businesslogic.Business.*(..))")
    public void logerMainConfig(){}
}
