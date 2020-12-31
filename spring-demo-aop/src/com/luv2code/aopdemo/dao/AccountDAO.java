package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public boolean doWork() {
		System.out.println(getClass() + ": DOING WORK");
		return false;
	}
	
	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": ADDING AN ACCOUNT");
		
	}
	
}
