package com.example.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
	
	Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut(value = "execution(* com.example.*.*.*(..))")
	public void pt1() {}
	
	@Before(value = "pt1()")
	public void beforeAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("methodName: {} args: {}", methodName, Arrays.toString(args));
	}
}
