package com.coffey.availity.model;

public class Enrollee {
	
	private String userId;
	private String firstName;
	private String lastName;
	private int version;
	private String insuranceCompany;
	
	
	
	
	public Enrollee(String userId, String firstName, String lastName, int version, String insuranceCompany) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.insuranceCompany = insuranceCompany;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
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

	@Override
	public String toString() {
		return "Enrollee [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", version="
				+ version + ", insuranceCompany=" + insuranceCompany + "]";
	}

	
}
