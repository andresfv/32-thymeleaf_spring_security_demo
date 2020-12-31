package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		AccountDAO theAccountDao = context.getBean("accountDAO",
				AccountDAO.class);

		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",
				MembershipDAO.class);

		Account theAccount = new Account();
		theAccount.setName("Andrés");
		theAccount.setLevel("Platinum");

		theAccountDao.addAccount(theAccount, true);

		theMembershipDAO.addAccount();

		theMembershipDAO.addSillyMember();

		theAccountDao.doWork();

//		theMembershipDAO.gotToSleep();

		theAccountDao.setName("the Name");
		theAccountDao.setServiceCode("the Service");

		theAccountDao.setName("the Name");
		theAccountDao.getServiceCode();

		context.close();
	}

}
