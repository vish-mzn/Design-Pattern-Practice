package com.project.work.model;

public class Employee {
	
	private String name;
	private String gender;
	private int days;
	
	
	public Employee(String name, String gender, int days) {
		super();
		this.name = name;
		this.gender = gender;
		this.days = days;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}

}
