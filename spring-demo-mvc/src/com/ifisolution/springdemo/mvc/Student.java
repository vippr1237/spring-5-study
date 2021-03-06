package com.ifisolution.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String city;
	private String favoriteLanguage;
	private String[] operatingSystem;

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	private LinkedHashMap<String, String> cityOptions;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student() {
		cityOptions = new LinkedHashMap<String, String>();

		cityOptions.put("HN", "Ha Noi");
		cityOptions.put("Hue", "Hue");
		cityOptions.put("DN", "Da Nang");
		cityOptions.put("HCM", "Ho Chi Minh");
		cityOptions.put("HD", "Hai Duong");
	}

	public LinkedHashMap<String, String> getCityOptions() {
		return cityOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
