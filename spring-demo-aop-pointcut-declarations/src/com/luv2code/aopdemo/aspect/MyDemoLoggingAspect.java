package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// Permite llamar un aop antes de ejecutar un metodo que coincida con los
	// criterios de busqueda en el pointcut
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.excludeSetterGetter()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
		MethodSignature methodSignature = (MethodSignature) theJointPoint
				.getSignature();
		System.out.println("Method: " + methodSignature);

		Object[] args = theJointPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
	}
}
