package com.ifisolution.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ifisolution.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("huy trinh");
		}
		List<Account> accounts = new ArrayList<>();

		accounts.add(new Account("Huy", "Demon"));
		accounts.add(new Account("Ha", "Thunder God"));
		accounts.add(new Account("Duc", "Lord"));
		return accounts;
	}

	public boolean addHuyTrinh(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": doing my db work: adding account");
		return false;
	}

	public void hello() {
		System.out.println(getClass() + ": hello");
	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}

}
