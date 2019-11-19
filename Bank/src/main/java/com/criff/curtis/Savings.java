package com.criff.curtis;

import java.text.DecimalFormat;

public class Savings extends Account {
	private static String accountType = "Savings";
	private static DecimalFormat df2 = new DecimalFormat("#,###.00");
	
	Savings(double initialDeposit){
		super();
		this.setBalance(initialDeposit);
		if(initialDeposit > 10000) {
			this.setInterest(0.10); // set savings' initial interest rate to 10%
		}
		else {
			this.setInterest(0.05); // set savings' initial interest rate to 5%
		}		
	} // end of saving();	
	
	@Override
	public String toString() {
		return //"+================================================+>\n"          +
			   "|     " + "Account Type   : " + accountType + " Account"        + "\n" + 
			   "|     " + "Account Number : " + this.getAccountNumber()         +" \n" +
			   "|     " + "Balance        : " + df2.format(this.getBalance())   + "\n" + 
			   "|     " + "Interest Rate  : " + this.getInterest() + "%"        + "\n" + 
			   "+================================================+>";		
	} // end of toString()	
} // end of savings class