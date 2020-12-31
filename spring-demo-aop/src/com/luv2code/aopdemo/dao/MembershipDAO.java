package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass() + " :Adding membership account");
	}
	
	public boolean addSillyMember() {
		System.out.println(getClass() + " :Adding a silly member");
		return true;
	}
	
	public void gotToSleep() {
		System.out.println(getClass()+": I'm going to sleep now");
	}
}
