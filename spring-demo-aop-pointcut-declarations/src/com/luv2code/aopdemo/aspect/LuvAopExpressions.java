package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {

//	Permite crear una variable en forma de metodo para poder utilizar el aop desde otro metodo
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forGetter() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forSetter() {
	}

	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	public void excludeSetterGetter() {
	}
}
