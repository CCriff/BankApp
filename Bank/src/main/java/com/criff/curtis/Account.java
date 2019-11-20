package com.criff.curtis;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;



public class Account {
	private final String username ="", password = "";
	private double balance = 0.00;
	private double interest = 0.04;
	private int accountNumber;
	private static int numberOfAccounts = 1000;
	private static DecimalFormat df2 = new DecimalFormat("#,###.00");
	Date date = new Date();
	
	// A String variable ArrayList that holds the list of all the transactions
	protected ArrayList<String> transactionsList = new ArrayList<String>();

	boolean verify(String name, String password)
    {
        return this.username.equals(username) && this.password.equals(password);
    }
	
//	Account acct1 = new Account();
//	Account acct2 = new Account();
	
	
	


	Account(){
		accountNumber = numberOfAccounts++; // set account number
	}
	
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest * 100;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}
	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	
	// not needed because the number never changes
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	
	/**
	 * @return the transactionsList
	 */
	public ArrayList<String> getTransactionsList() {
		return transactionsList;
	}

	/**
	 * @param transactionsList the transactionsList to set
	 */
	public void setTransactionsList(ArrayList<String> transactionsList) {
		this.transactionsList = transactionsList;
	}
	
	public void withdrawal(double amount) {
		if(amount + 5 > balance) {
			System.out.println("Transaction Cannot Be Completed. You Have Insuffient Funds.");
		}
		
		checkInterest(); // reset interest rate each time you make a withdrawal
		
		balance -= amount + 5; // adds a $5 fee for withdrawals... 
		System.out.println("\n$" + df2.format(amount) + " Has Been Withdrawn From Your Account With Account Number: " + accountNumber + " And Incurred A Bank Fee Of $5.\n");
        System.out.println("\n$" + df2.format(balance) + " Is Your New Balance.\n" );
        transactionsList.add("Time: " + date.toString() + " Withdrawal Amount: " + "$" + df2.format(amount) + " New Balance: " + "$" + df2.format(balance) + accountNumber);
        
	} // end of withdrawal method
	
	public void deposit(double amount) {
		if (amount <= 0) {

            System.out.println("You Cannot Deposit A Negative Amount To Your Account.\n");
			return;
		}
		
		checkInterest(); // reset interest rate each time you make a deposit
		
		amount = amount + amount * interest;
		balance += amount;
		System.out.println("\n$" + df2.format(amount) + " Has Been Deposied Into Your Account With Account Number: " + accountNumber + "An Interest Rate of " + (interest * 100) + "%");
        System.out.println("\n$" + df2.format(balance) + " Is Your New Balance.\n" );
        transactionsList.add("Time: " + date.toString() + " Deposit Amount: " + "$" + df2.format(amount) + " New Balance: " + "$" + df2.format(balance) + accountNumber);
        
		
	} // end of deposit method
	
	public void transfer(Account acct, double amount) {
		if(amount > balance) {
			System.out.println("Transaction Cannot Be Completed. You Have Insuffient Funds.");
		}		
		 balance = amount;
		 acct.deposit(amount);
		 this.withdrawal(amount);
		
		System.out.println("\n$" + df2.format(amount) + " Has Been Transferred From Your Account With Account Number: " + this.accountNumber
				         + " And Has Been Deposited into Account With Account Number: " + getAccountNumber());
        System.out.println("\n$" + df2.format(balance) + " Is Your New Balance.\n" );
        transactionsList.add("Time: " + date.toString() + " Withdrawal Amount: " + "$" + df2.format(amount) + " New Balance: " + "$" + df2.format(balance) + accountNumber);
        
	} // end of withdrawal method
	
	public void checkInterest(){
    	if(balance > 10000) {
    		interest = 0.08;
    	} else {
    		interest = 0.04;
    	}
    }
	

} // end of account class
