package ru.gb.Patterns_HW12.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    private Logger log = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object [] args = joinPoint.getArgs();
        String method = joinPoint.getSignature().getName();
        Object returnedByMethod = joinPoint.proceed();
        log.info("User used method:  " + method + "  with args  " + Arrays.toString(args) + " and get " + returnedByMethod);
        return returnedByMethod;
    }

}