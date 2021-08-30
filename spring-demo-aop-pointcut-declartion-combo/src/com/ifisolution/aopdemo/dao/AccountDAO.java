package com.ifisolution.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ifisolution.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

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
