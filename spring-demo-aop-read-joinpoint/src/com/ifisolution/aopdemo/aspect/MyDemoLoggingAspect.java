package com.ifisolution.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
