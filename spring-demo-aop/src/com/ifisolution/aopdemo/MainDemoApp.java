package com.ifisolution.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ifisolution.aopdemo.dao.AccountDAO;
import com.ifisolution.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		Account account = new Account();
		accountDAO.addHuyTrinh(account, true);
		accountDAO.hello();
		membershipDAO.addAccount();
		membershipDAO.sleep();
		context.close();
	}

}
