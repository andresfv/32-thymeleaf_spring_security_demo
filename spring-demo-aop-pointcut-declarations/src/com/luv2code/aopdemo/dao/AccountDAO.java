package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + ": IN GET NAME()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": IN SET NAME()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": IN GET SERVICE()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": IN SET SERVICE()");
		this.serviceCode = serviceCode;
	}

	public boolean doWork() {
		System.out.println(getClass() + ": DOING WORK");
		return false;
	}
	
	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": ADDING AN ACCOUNT");
		
	}
	
}
