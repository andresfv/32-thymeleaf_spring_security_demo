package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	// Permite llamar un aop antes de ejecutar un metodo que coincida con los
	// criterios de busqueda en el pointcut
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.excludeSetterGetter()")
	public void logToCloudsAsync() {
		System.out.println("\n====>>> Loggin to Cloud un async fashion");

	}

}
