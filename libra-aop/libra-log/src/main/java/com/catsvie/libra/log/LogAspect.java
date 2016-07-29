package com.catsvie.libra.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class LogAspect {
	private Throwable throwable;

	@Pointcut("execution(* *(..)) "
			+ "&& !within(*..*Test) "
			+ "&& !@within(NoLogging) "
			+ "&& !@annotation(NoLogging) "
			+ "&& !execution(* *..entities..*.get*(..))"
			+ "&& !execution(* *..entities..*.is*(..))"
			+ "&& !execution(* *..entities..*.set*(..))")
	public void allFunctions() {

	}

	@Pointcut("(execution(public * *(..))) "
			+ "&& !within(*..*Test)"
			+ "&& !@within(NoLogging) "
			+ "&& !@annotation(NoLogging) "
			+ "&& !execution( String *.toString()) "
			+ "&& !execution(* *..entities..*.get*(..))"
			+ "&& !execution(* *..entities..*.is*(..))"
			+ "&& !execution(* *..entities..*.set*(..))")
	public void logableFunctions() {

	}

	@Pointcut("@annotation(Logging)")
	public void logFunctions() {

	}

	@AfterThrowing(pointcut = "allFunctions()", throwing = "throwable")
	public void logThrowable(JoinPoint jp, Throwable throwable) throws Throwable {
		if (this.throwable == throwable) {
			throw throwable;
		} else {
			this.throwable = throwable;
		}
		Logger logger = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		if (throwable instanceof Error) {
			logger.error("Error Detected: ", throwable);
		} else {
			logger.error("Exception Detected: ", throwable);
		}
		throwable.printStackTrace();
		throw throwable;
	}

	@Before("logableFunctions()")
	public void logEnterFunction(final JoinPoint jp) {
		Logger logger = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		logger.trace("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}

	@AfterReturning(pointcut = "logableFunctions()", returning = "o")
	public void logReturningFunction(final JoinPoint jp, Object o) {
		Logger logger = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		logger.trace("{} DONE. Args: {}. Returning: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()), o);
	}

	@AfterReturning(pointcut = "logFunctions()", returning = "o")
	public void logReturning(final JoinPoint jp, Object o) {
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Logging logAnnotation = signature.getMethod().getAnnotation(Logging.class);
		Logger logger = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		switch (logAnnotation.value()) {
			case ERROR:
				logger.error("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case DEBUG:
				logger.debug("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case TRACE:
				logger.trace("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case WARN:
				logger.warn("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case INFO:
			default:
				logger.info("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
		}
	}

	@Before("logFunctions()")
	public void logEnter(final JoinPoint jp) {
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Logging logAnnotation = signature.getMethod().getAnnotation(Logging.class);
		Logger logger = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		switch (logAnnotation.value()){
			case ERROR:
				logger.error("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case DEBUG:
				logger.debug("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case TRACE:
				logger.trace("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case WARN:
				logger.warn("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
			case INFO:
			default:
				logger.info("{} START. Args: {} ", jp.getSignature(), Arrays.toString(jp.getArgs()));
				return;
		}
	}
}