package com.criff.curtis;

public class Employee {
	private String firstName;
	private String lastName;
	private String ssn;
	private Account account;

	Employee(String firstName, String lastName, String ssn, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.account = account;
	}
	
	@Override
	public String toString() {
		return("\nCustomer Information:\n" + 
				"First Name: " + firstName + "\n" +
				"Last Name: " + lastName + "\n" + 
				"Social Security Number: " + ssn + "\n" + 
				 account + "\n");
	}
	
	public String basicInfo() {
		return("First Name: " + firstName + "\n" +
			   "Last Name: " + lastName + "\n" + 
			   "Social Security Number: " + ssn + "\n" + 
			   "Account Number: " + account.getAccountNumber() + "\n");
	}
	
	Account getAccount() {
		return account;
	}

}
