package com.ifisolution.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
