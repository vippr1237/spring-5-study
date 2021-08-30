package com.ifisolution.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ifisolution.aopdemo.Account;

@Component
public class AccountDAO {
	public boolean addHuyTrinh(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": doing my db work: adding account");
		return false;
	}

	public void hello() {
		System.out.println(getClass() + ": hello");
	}
}
