package com.criff.curtis;

import java.util.ArrayList;

public class Bank {
	
	ArrayList<Customers> customer = new ArrayList<Customers>();

	void addCustomers(Customers customers) {
		customer.add(customers);
		
	}

	Customers getCustomers(int account) {

		return customer.get(account);
	}
	
	ArrayList<Customers> getCustomers(){
		return customer;
	}
	

}
