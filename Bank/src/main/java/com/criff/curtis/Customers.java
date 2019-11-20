package com.criff.curtis;

import java.io.Serializable;

public class Customers {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String jointAccount = "";
	private String jointFirstName;
	private String jointLastName;
	private String jointSSN;
	private String username;
	private String password;
	private String address;
	private String phone;
	private String ssn;
	private Account account;

	Customers(String firstName, String lastName, String jointFirstName, String jointLastName, String jointSSN, 
			  String username, String password, String ssn, String address, String phone, String jointAccount, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.jointAccount = jointAccount;
		this.jointFirstName = jointFirstName;
		this.jointLastName = jointLastName;
		this.jointSSN = jointSSN;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.ssn = ssn;
		this.account = account;
	}

	@Override
	public String toString() {
		return( "\n+================================================+>\n" +
				"|     " + "Customer Information:\n" + 
				"|     " + "First Name     : " + firstName + "\n" +
				"|     " + "Last Name      : " + lastName + "\n" +
				"|     " + "Address        : " + address + "\n" +
				"|     " + "Phone Number   : " + phone + "\n" +
				"|     " + "SSN            : " + ssn + "\n" +
				"|     " + "Joint Account  : " + jointAccount + "\n" +
				"|     " + "First Name     : " + jointFirstName + "\n" +
				"|     " + "Last Name      : " + jointLastName + "\n" +
				"|     " + "SSN            : " + jointSSN + "\n" +
				"|     " +  account            + "\n" +  
				"+================================================+>");
	}
	
	public String basicInfo() {
		return("\n+================================================+>\n" + 
			   "|     " + "First Name     : " + firstName + "\n" +
			   "|     " + "Last Name      : " + lastName + "\n" + 
			   "|     " +  account            + "\n" +
			   "|     " + "Account Number : " + account.getAccountNumber() + "\n" + 
			   "+================================================+>\n");
	}
	
	Account getAccount() {
		return account;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the jointFirstName
	 */
	public String getJointFirstName() {
		return jointFirstName;
	}

	/**
	 * @param jointFirstName the jointFirstName to set
	 */
	public void setJointFirstName(String jointFirstName) {
		this.jointFirstName = jointFirstName;
	}

	/**
	 * @return the jointLastName
	 */
	public String getJointLastName() {
		return jointLastName;
	}

	/**
	 * @param jointLastName the jointLastName to set
	 */
	public void setJointLastName(String jointLastName) {
		this.jointLastName = jointLastName;
	}

	/**
	 * @return the jointSSN
	 */
	public String getJointSSN() {
		return jointSSN;
	}

	/**
	 * @param jointSSN the jointSSN to set
	 */
	public void setJointSSN(String jointSSN) {
		this.jointSSN = jointSSN;
	}
	
	/**
	 * @return the jointAccount
	 */
	public String getJointAccount() {
		return jointAccount;
	}

	/**
	 * @param jointAccount the jointAccount to set
	 */
	public void setJointAccount(String jointAccount) {
		this.jointAccount = jointAccount;
	}

}
