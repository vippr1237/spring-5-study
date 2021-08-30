package com.ifisolution.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

	@Pointcut("execution(* com.ifisolution.aopdemo.dao.*.get*(..))")
	public void getter() {

	}

	@Pointcut("execution(* com.ifisolution.aopdemo.dao.*.set*(..))")
	public void setter() {

	}

	@Pointcut("execution(* com.ifisolution.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {

	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {

	}

}
