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
		account.setLevel("Demon");
		account.setName("Huy Trinh");
		accountDAO.addHuyTrinh(account, true);
		accountDAO.hello();
		membershipDAO.addAccount();
		membershipDAO.sleep();

		accountDAO.setName("Huy Trinh");
		accountDAO.setServiceCode("1234");
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		context.close();
	}

}
