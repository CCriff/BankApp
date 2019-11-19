package com.criff.curtis;

import java.text.DecimalFormat;

public class Checking extends Account {
	private static String accountType = "Checking";
	private static DecimalFormat df2 = new DecimalFormat("#,###.00");
	
	Checking(double initialDeposit){
		super();
		this.setBalance(initialDeposit);
		this.checkInterest();
		
	} // end of checking();
	
	@Override
	public String toString() {
		return //"+================================================+>\n"         +
			   "|     " + "Account Type   : " + accountType + " Account"       + "\n" + 
			   "|     " + "Account Number : " + this.getAccountNumber()        +" \n" +
			   "|     " + "Balance        : $"+ df2.format(this.getBalance())  + "\n" + 
			   "|     " + "Interest Rate  : " + df2.format(this.getInterest()) + "%"  + "\n" + 
			   "+================================================+>";
	} // end of toString()	
} // end of checking class