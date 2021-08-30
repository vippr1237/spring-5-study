package com.ifisolution.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + ": doing my db work: adding account");
	}

	public boolean sleep() {
		System.out.println(getClass() + ": going to sleep");

		return true;
	}
}
