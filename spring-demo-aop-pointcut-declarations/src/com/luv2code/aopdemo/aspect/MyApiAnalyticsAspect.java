package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	// Permite llamar un aop antes de ejecutar un metodo que coincida con los
	// criterios de busqueda en el pointcut
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.excludeSetterGetter()")
	public void performAPIAnalitics() {
		System.out.println("\n====>>> Executing Performing API analytics");

	}

}
