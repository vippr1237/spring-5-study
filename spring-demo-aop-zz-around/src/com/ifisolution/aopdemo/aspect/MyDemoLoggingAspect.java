package com.ifisolution.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ifisolution.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Around("execution(* com.ifisolution.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> Executing @Around on method: " + method);

		long begin = System.currentTimeMillis();

		Object result = proceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;

		System.out.println("\n======> Duration: " + duration / 1000.0 + "s");

		return result;
	}

	@After("execution(* com.ifisolution.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		System.out.println("\n=====> Executing @After (finally) on method: " + methodSig);
	}

	@AfterThrowing(pointcut = "execution(* com.ifisolution.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "e")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		System.out.println("\n=====> Executing @AfterThrowing on method: " + methodSig);

		System.out.println("The exception is: " + e);
	}

	@AfterReturning(pointcut = "execution(* com.ifisolution.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		System.out.println("\n=====> Executing @AfterReturning on method: " + methodSig);

		System.out.println("Result is: " + result);

		convertAccountNamesToUpperCase(result);
		System.out.println("Result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperCase = account.getName().toUpperCase();

			account.setName(upperCase);
		}

	}

	@Before("com.ifisolution.aopdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====> Executing @Before advice on addAccount");
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		Object[] args = joinPoint.getArgs();

		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println(account.getName());
				System.out.println(account.getLevel());
			}
		}
	}

}
