package com.criff.curtis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	// Instance Variables
	Scanner scan = new Scanner(System.in);
	private static DecimalFormat df2 = new DecimalFormat("#,###.00");

	Bank bank = new Bank();
    int userPick;

    boolean quit = false;

    double balance = 0d;
	
	public static void main(String[] args) {
		
		
/*
 * =========================================================Connect-Database==================================================	
 */		
		// Connect to postgreSQL database		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://bankapp.cua8a0jy3iil.us-east-2.rds.amazonaws.com/", "postgres", "lost1soul")) {
			 
            System.out.println("Connecting To The BANK OF CRIFF\n");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
            System.out.println("Connected To The BANK OF CRIFF'S PostgreSQL Database!\n");
            Statement statement = connection.createStatement();
            System.out.println("Reading Bank Records...\n");
            System.out.printf("%-30.30s  %-30.30s%n", "First Name", "SSN");
            ResultSet resultSet = statement.executeQuery("select * from customer;");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("first_name"), resultSet.getString("ssn"));
                
            }
            
            System.out.println("\nConnected Successfully!");          
            
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		
		
		
/*
 * =========================================================CREATE-MENUS==================================================	
 */		
		Menu menuLogin = new Menu();  // create main login menu
		Menu menu = new Menu();  // create main menu
		Menu menu2 = new Menu(); // create employee menu
		Menu menu3 = new Menu(); // create customer menu
		Menu menu4 = new Menu(); // create Manager menu
		
		menuLogin.runLoginMenu(); // runs log in menu
		menu.runMenu();  // runs main menu
		menu2.runMenu(); // runs employee menu
		menu3.runMenu(); // runs customer menu
		menu4.runMenu(); // runs manager menu
		

    
	} // end of main

/*
 * =========================================================Login-MENU==================================================	
 */	
	
	// Run Login Menu... Also used as log out method...	
	public void runLoginMenu() {
		printLoginHeader(); // runs Log in header
		printLoginMenu();
		while(!quit) {
			int loginChoice = getLoginInput(); // gets user input
			performLoginAction(loginChoice);	// performs actions based on user input		
		}		
	} // end of run Login Menu
	
	// Print Login message
	private void printLoginHeader() {
		System.out.println("");
		System.out.println("+--------------------------+");
		System.out.println("|      PLEASE LOG IN       |");
		System.out.println("|    TO USE THIS SYSTEM    |");
		System.out.println("+--------------------------+");
		System.out.println("");		
	} // end of print Login Header
				
	// Print Login Menu
	private void printLoginMenu() {
		System.out.println("Please Make A Selection From The Menu Below:\n");
		System.out.println("1) LOG-IN");
		System.out.println("0) Exit\n");
	} // end of Login Type
	
	// get user input
	private int getLoginInput() {
		int loginChoice = -1;
		do {
			System.out.print("Enter Your Choice: \n");
			try {
				loginChoice = Integer.parseInt(scan.nextLine());				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Please Use The Numberpad To Make A Selection.");
			}
			if(loginChoice < 0 || loginChoice > 1) {
				System.out.println("Choice Is Outside Of Range. Please Pick Another Option");
			}			
		}
		while(loginChoice < 0 || loginChoice > 1);		
		return loginChoice;		
	} // end of get Login Input
	
	// performs actions based on user input
	private void performLoginAction(int loginChoice) {
		switch(loginChoice) {	
			case 0:
				// exit application
				System.out.println("Thank You For Using The Bank Of CRIFF Banking App. Have A Nice Day!");
				System.exit(0);
				break;
			case 1:
				// run login()/menu();
				login();
				break;
			default:
				System.out.println("Unknown Error Has Occurred.\n");			
			} // end of switch case for log in		
		} // end of performAction for log in
	
	private void login() {
		
		
		runMenu();
		
//		int credentials = -1;
//		do {
//			System.out.print("Please Enter Your Account Number or Username: \n");
//			try {
//				credentials = (int) Integer.parseInt(scan.nextLine());				
//			}
//			catch(NumberFormatException e) {
//				System.out.println("Invalid Selection. Please Use The Numberpad To Make A Selection.");
//			}
//			if(credentials < 0 || credentials > 4) {
//				System.out.println("Choice Is Outside Of Range. Please Pick Another Option");
//			}			
//		}
//		while(credentials < 0 || credentials > 4);		
//		return credentials;	
		
		
	}

/*
 * =========================================================MAIN-MENU==================================================	
 */		
	
	
	// Run Main Menu 	
	public void runMenu() {
		printHeader(); // runs main header
		while(!quit) {
			printLoginType(); // runs login Menu
			int choice = getInput(); // gets user input
			performAction(choice);	// performs actions based on user input		
		}		
	} // end of run Menu
	
	// Print Welcome message
	private void printHeader() {
		System.out.println("");
		System.out.println("+--------------------------+");
		System.out.println("|      WELCOME TO THE      |");
		System.out.println("|      BANK OF CRIFF       |");
		System.out.println("+--------------------------+");
		System.out.println("");		
	} // end of printHeader
	
	// Print Select Type of User Menu
	private void printLoginType() {
		System.out.println("Please Make A Selection From The Menu Below:\n");
		System.out.println("1) Are You An Employee?");
		System.out.println("2) Are You A Customer?");
		System.out.println("3) Are You A Bank Administrator?");
		System.out.println("4) Log Out");
		System.out.println("0) Exit\n");
	} // end of Select Type of User Menu
	
	// Get User input
	private int getInput() {
		int choice = -1;
		do {
			System.out.print("Enter Your Choice: \n");
			try {
			choice = Integer.parseInt(scan.nextLine());				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Please Use The Numberpad To Make A Selection.");
			}
			if(choice < 0 || choice > 4) {
				System.out.println("Choice Is Outside Of Range. Please Pick Another Option");
			}			
		}
		while(choice < 0 || choice > 4);		
		return choice;		
	} // end of getInput
	
	// performs actions based on user input
	private void performAction(int choice) {
		switch(choice) {	
		case 0:
			// exit application
			System.out.println("Thank You For Using Our Banking App. Have A Nice Day!");
			System.exit(0);
			break;
		case 1:
			// run employee login()/menu();
			runMenu2();
			break;
		case 2:
			// run customer login()/menu();
			runMenu3();
			break;
		case 3:
			// run Administrator/Manager login()/menu();
			runMenu4();
			break;
		case 4:
			// Go Back To Login Menu();
			runLoginMenu();		
            break;
		default:
			System.out.println("Unknown Error Has Occurred.\n");			
		} // end of switch case for log in		
	} // end of performAction for log in
	
/*
 * =========================================================EMPLOYEE==================================================	
 */
	
	// Run menu options for Employees
	public void runMenu2() {
		printHeader2();
		while(!quit) {
			printMenu2();
			int choice2 = getInput2();
			performAction2(choice2);
		}		
	} // end of runMenu2 for employees
	
	// employee header
	private void printHeader2() {
		System.out.println("");
		System.out.println("+--------------------------+");
		System.out.println("|        EMPLOYEES         |");
		System.out.println("+--------------------------+");
		System.out.println("");		
	} // end of printHeader for employee
	
	// menu for Employees
	private void printMenu2() {
		System.out.println("Please Make A Selection From The Menu Below:\n");
		System.out.println("1) Approve An Application");
		System.out.println("2) Deny A Application");
		System.out.println("3) View An Account Information"); // view customers basic info
		System.out.println("4) Go Back To Main Menu");
		System.out.println("5) Log Out");
		System.out.println("0) Exit\n");			
	} // end of printMenu for employee
	
	// get input from employees
	private int getInput2() {
		int choice2 = -1;
		do {
			System.out.print("Enter Your Choice: \n");
			try {
			choice2 = Integer.parseInt(scan.nextLine());				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Please Use The Numberpad To Make A Selection.\n");
			}
			catch(NonDigitNumberException e) {
				e.printStackTrace();
			}
			if(choice2 < 0 || choice2 > 5) {
				System.out.println("Choice Is Outside Of Range. Please Pick Another Option.\n");
			}			
		}
		while(choice2 < 0 || choice2 > 5);		
		return choice2;		
	} // end of getInput2 for employees
	
	// performs actions based on employee input
	private void performAction2(int choice2) {
		switch(choice2) {
		
		case 0:
			// exit application
			System.out.println("Thank You For Using Our Banking App. Have A Nice Day!");
			System.exit(0);
			quit = true;
			break;
		case 1:
			// approve an account();
			approveAccount();
			break;
		case 2:
			// deny a deposit();
			denyAccount();
			break;
		case 3:
			// check an account balance();
			checkBalance();
			break;
		case 4:
			// Go Back To Main Menu();
			runMenu();		
            break;
		case 5:
			// Go Back To Login Menu();
			runLoginMenu();		
            break;
		default:
			System.out.println("Unknown Error Has Occurred.");			
		} // end of switch case	for employees	
	} // end of performAction for employees
	
/*
 * =========================================================CUSTOMERS==================================================	
 */
	
	// Run menu options for Customers
	public void runMenu3() {
		printHeader3();
		while(!quit) {
			printMenu3();
			int choice3 = getInput3();
			performAction3(choice3);
		}
		
	} // end of runMenu2 for Customers
	
	// employee customers
	private void printHeader3() {
		System.out.println("");
		System.out.println("+--------------------------+");
		System.out.println("|        CUSTOMERS         |");
		System.out.println("+--------------------------+");
		System.out.println("");
		
	} // end of printHeader for customers
	
	// menu for Customers
	private void printMenu3() {
		System.out.println("Please Make A Selection From The Menu Below:\n");
		System.out.println("1) Create A New Account");
		System.out.println("2) Make A Deposit");
		System.out.println("3) Make A Withdrawal");
		System.out.println("4) Tranfer Funds");		
		System.out.println("5) Check Account Information");
		System.out.println("6) Go Back To Main Menu");
		System.out.println("7) Log Out");
		System.out.println("0) Exit\n");		
		} // end of printMenu for customers
	
	// get input from customers	
	private int getInput3() {
		int choice3 = -1;
		do {
			System.out.print("Enter Your Choice: \n");
			try {
			choice3 = Integer.parseInt(scan.nextLine());				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Please Use The Numberpad To Make A Selection.");
			}
			if(choice3 < 0 || choice3 > 7) {
				System.out.println("Choice Is Outside Of Range. Please Pick Another Option");
			}			
		}
		while(choice3 < 0 || choice3 > 7);		
		return choice3;		
	} // end of getInput from customers
	
	// performs actions based on customer input
	private void performAction3(int choice3) {
		switch(choice3) {
		
		case 0:
			// exit application
			System.out.println("Thank You For Using Our Banking App. Have A Nice Day!");
			System.exit(0);
			quit = true;
			break;
		case 1:
			// create an account();
			createAccount();
			break;
		case 2:
			// make a deposit();
			makeDeposit();
			break;
		case 3:
			// make a withdrawal();
			makeWithdrawal();
			break;
		case 4:
			// make a withdrawal();
			makeTransfer();
			break;
		case 5:
			// check balance();
			checkBalance();		
            break;
		case 6:
			// check balance();
			runMenu();		
            break;
		case 7:
			// Go Back To Login Menu();
			runLoginMenu();		
            break;
		default:
			System.out.println("Unknown Error Has Occurred.");			
		} // end of switch case for customers		
	} // end of performAction from customer input
	
/*
 * =========================================================ADMINS==================================================	
 */	
		
	// Run menu options for ADMINS
	public void runMenu4() {
		printHeader4();
		while(!quit) {
			printMenu4();
			int choice4 = getInput4();
			performAction4(choice4);
		}
		
	} // end of runMenu2 for ADMINS
	
		private void printHeader4() {
			System.out.println("");
			System.out.println("+--------------------------+");
			System.out.println("|          ADMINS          |");
			System.out.println("+--------------------------+");
			System.out.println("");
			
		} // end of printHeader for ADMINS	

		// menu for ADMINS
		private void printMenu4() {
			System.out.println("Please Make A Selection From The Menu Below:\n");
			System.out.println("1) Approve An Application");
			System.out.println("2) Deny A Application");
			System.out.println("3) Make A Deposit");
			System.out.println("4) Make A Withdrawal");
			System.out.println("5) Transfer Funds Between Accounts");
			System.out.println("6) View Account Information"); // view full/extended customer info
			System.out.println("7) Edit Account Information"); 
			System.out.println("8) Cancel Accout");
			System.out.println("9) Go Back To Main Menu");
			System.out.println("10) Log Out");
			System.out.println("0) Exit\n");			
		} // end of printMenu for ADMINS
		
		// get input from ADMINS	
		private int getInput4() {
			int choice4 = -1;
			do {
				System.out.print("Enter Your Choice: \n");
				try {
				choice4 = Integer.parseInt(scan.nextLine());				
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid Selection. Please Use The Numberpad To Make A Selection.");
				}
				if(choice4 < 0 || choice4 > 10) {
					System.out.println("Choice Is Outside Of Range. Please Pick Another Option");
				}			
			}
			while(choice4 < 0 || choice4 > 10);		
			return choice4;		
		} // end of getInput from ADMINS
		
		// performs actions based on ADMINS input
		private void performAction4(int choice4) {
			switch(choice4) {
			
			case 0:
				// exit application
				System.out.println("Thank You For Using Our Banking App. Have A Nice Day!");
				System.exit(0);
				quit = true;
				break;
			case 1:
				// approve an account();
				approveAccount();
				break;
			case 2:
				// deny a deposit();
				denyAccount();
				break;
			case 3:
				// make a deposit();
				makeDeposit();
				break;
			case 4:
				// make a withdrawal();
				makeWithdrawal();
				break;
			case 5:
				// make a transfer();
				makeTransfer();
				break;
			case 6:
				// view account info();
				checkBalance();		
	            break;
			case 7:
				// edit account info();
				editInfo();		
	            break;
			case 8:
				// cancel account();
				canelAccount();		
	            break;
			case 9:
				// Go Back To Main Menu();
				runMenu();		
	            break;
			case 10:
				// Go Back To Login Menu();
				runLoginMenu();		
	            break;
			default:
				System.out.println("Unknown Error Has Occurred.");			
			} // end of switch case for ADMINS		
		} // end of performAction from ADMIN input

/*
 * =======================================================METHODS==================================================	
 */

	private void createAccount() {
		String firstName, lastName, address = "", phone = "", ssn, jointAccount = "", jointFirstName = "", jointLastName = "", jointSSN = "", username = "", password = "",  accountType = "";
		double initialDeposit = 0;
		boolean valid = false;
		boolean isEmpty = false;
		while(!valid) {
			System.out.print("Please Enter An Account Type (Checking/Savings):");
			accountType = scan.nextLine();
			if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
				valid = true;				
			}
			else {
				System.out.println("Invalid Account Type Was Selected. Please Enter Checking or Savings. ");
			}
		}
		
			System.out.print("Will This Be A Joint Account?");
			jointAccount = scan.nextLine();
			if(jointAccount.equalsIgnoreCase("yes")) {
				
				jointAccount = "Yes";
				System.out.print("Please Enter Joint Account Holder First Name: ");				
				jointFirstName = scan.nextLine();
				
				System.out.print("Please Enter Joint Account Holder Last Name: ");				
				jointLastName = scan.nextLine();
				
				System.out.print("Please Enter Joint Account Holder SSN: ");				
				jointSSN = scan.nextLine();
				
			}
			else {
				jointAccount = "No";
			}
		
		
		
		
		System.out.print("Please Enter Primary Account Holder First Name: ");
		
		firstName = scan.nextLine();
		
		
		do {
			// Validate if User left First name empty or just entered spaces, which means it is empty. 
			if (firstName == null || firstName.trim().isEmpty()) {
				System.out.print("\nYou Can't Leave This Field Empty.\n" + "\n" + "Please Enter Your First Name: ");

				firstName = scan.nextLine();
			// Validate if User types numeric values as First Name.	
			} else if (firstName.matches("[0-9]+")) {
				System.out.print("\nYou Can't Have Digits In Your Name.\n" + "\n" + "Please Enter Your First Name: ");

				firstName = scan.nextLine();
			// Validate if user types numbers and letters or letters and numbers for First Name.	
			} else if (firstName.matches("[a-zA-Z]+[0-9]+") || firstName.matches("[0-9]+[a-zA-Z]+")) {
				System.out.print("\nYou Can't Have Both Digits And Characters In Your Name.\n" + "\n" + "Please Enter Your First Name: ");

				firstName = scan.nextLine();
				
			} else {
				
				isEmpty = true;
				
			}
		} while (!(isEmpty));
		
		
		System.out.print("Please Enter Primary Account Holder Last Name: ");
		
		lastName = scan.nextLine();
		
		isEmpty = false;
		do {
			// Validate if User left Last name empty or just entered spaces, which means it is empty. 
			if (lastName == null || lastName.trim().isEmpty()) {
				System.out.print("\nYou Can't Leave This Field Empty.\n" + "\n" + "Please Enter Your Last Name: ");

				lastName = scan.nextLine();
			// Validate if User types numeric values as Last Name.	
			} else if (lastName.matches("[0-9]+")) {
				System.out.print("\nYou Can't Have Digits In Your Name.\n" + "\n" + "Please Enter Your Last Name: ");

				lastName = scan.nextLine();
			// Validate if user types numbers and letters or letters and numbers for Last Name.	
			} else if (lastName.matches("[a-zA-Z_0-9]+[0-9]+") || lastName.matches("[0-9]+[a-zA-Z]+")) {
				System.out.print("\nYou Can't Have Both Digits And Characters In Your Name.\n" + "\n" + "Please Enter Your Last Name: ");

				lastName = scan.nextLine();
				
			} else {
				
				isEmpty = true;
				
			}
		} while (!(isEmpty));
		
		
		System.out.print("Please Enter Your Social Security Number: ");
		
		ssn = scan.nextLine();
		
		isEmpty = false;
		do {
			// Validate if User left ssn empty or just entered spaces, which means it is empty. 
			if (ssn == null || ssn.trim().isEmpty()) {
				System.out.print("\nYou Can't Leave This Field Empty.\n" + "\n" + "Please Enter Your Social Security Number: ");

				ssn = scan.nextLine();
				
			// Validate if User types numeric values as ssn.	
			} else if (ssn.matches("[a-zA-Z]+")) {
				System.out.print("\nYou Can't Have Letters In Your Social Security Number.\n" + "\n" + "Please Enter Your Social Security Number: ");

				ssn = scan.nextLine();
			// Validate if user types numbers and letters or letters and numbers for ssn.	
			} else if (lastName.matches("[a-zA-Z]+[0-9]+") || ssn.matches("[0-9]+[a-zA-Z]+")) {
				System.out.print("\nYou Can't Have Both Digits And Characters In Your Social Security Number.\n" + "\n" + "Please Enter Your Social Security Number: ");

				ssn = scan.nextLine();
				
			} else {
				
				isEmpty = true;
				
			}
		} while (!(isEmpty));
		
		System.out.print("Please Enter Your Address: ");
		
		address = scan.nextLine();
		
		System.out.print("Please Enter Your Phone Number: ");
		
		phone = scan.nextLine();
		
		System.out.print("Please Enter Your Username: ");
		
		username = scan.nextLine();
		
		System.out.print("Please Enter Your Password: ");
		
		password = scan.nextLine();
		
		valid = false;
		while(!valid) {
			System.out.print("Please Enter An Initial Deposit: ");			
			try {
				initialDeposit = Double.parseDouble(scan.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("Deposit Must Be A Number");
			}
			if(accountType.equalsIgnoreCase("checking")) {
				if(initialDeposit < 100) {
					System.out.println("Checking Accounts Require A Minimum of $100 To Open.");
				} else {
					valid = true;
				}
			} else if(accountType.equalsIgnoreCase("savings")) {
				if(initialDeposit < 50) {
					System.out.println("Savings Accounts Require A Minimum of $50 To Open.");
				} else {
					valid = true;
					System.out.println("\n");
				}
			}
		}
		
		// create accounts
		Account account;
		if(accountType.equalsIgnoreCase("checking")) {
			account = new Checking(initialDeposit);
		} 
		else {
			account = new Savings(initialDeposit);
		}
		
		Customers customers = new Customers(firstName, lastName, address, phone, ssn, jointAccount, jointFirstName, jointLastName, jointSSN, account, username, password);
		bank.addCustomers(customers);
		System.out.println("\nYour Account Has Been Created Successfully!\n");
		System.out.println(account); // Prints out basic account info after the account has been created
		
		
	}


	private void makeDeposit() {
		int account = selectAccount();
		if(account >= 0) {
			
			System.out.print("How Much Do You Want To Deposit? ");
			double amount = 0;
			try {
				amount = Double.parseDouble(scan.nextLine());
			} catch(NumberFormatException e){
				amount = 0;
			}
			
			bank.getCustomers(account).getAccount().deposit(amount);
		}
	}


	private int selectAccount() {
		ArrayList<Customers> customers = bank.getCustomers();
		if(customers.size() <= 0 ) {
			System.out.println("\nUnfortunately, There Are No Customers At The Criff Bank.\n" +
		                        "Will You Be The First To Create An Account?\n");
			return -1;
		}
		System.out.println("Select An Account: \n");
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i + 1) + ") " + customers.get(i).basicInfo());
		}
		
		int account = 0;
		System.out.print("Please Enter Your Selection: ");
		try {
			account = Integer.parseInt(scan.nextLine()) -1;
		} catch(NumberFormatException e){
			account = -1;
		}
		
		if(account < 0 || account > customers.size()) {
			System.out.println("Invalid Account Selected.");
			account = -1;
		}
		return 0;
	}
	
	private int selectTransferAccount() {
		ArrayList<Customers> customers = bank.getCustomers();
		if(customers.size() <= 0 ) {
			System.out.println("\nUnfortunately, There Are No Customers At The Criff Bank.\n" +
		                        "Will You Be The First To Create An Account?\n");
			return -1;
		}
		System.out.println("Select An Account To Transfer Funds From: \n");
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i + 1) + ") " + customers.get(i).basicInfo());
		}
		double amount = 0;
		int account = 0;
		System.out.print("Please Enter Your Selection: ");
		try {
			account = Integer.parseInt(scan.nextLine()) -1;
		} catch(NumberFormatException e){
			account = -1;
		}
		
		if(account < 0 || account > customers.size()) {
			System.out.println("Invalid Account Selected.");
			account = -1;
		}
		bank.getCustomers(account).getAccount().withdrawal(amount);
		return 0;
	}

	private int selectTransferAccount2() {
		ArrayList<Customers> customers = bank.getCustomers();
		if(customers.size() <= 0 ) {
			System.out.println("\nUnfortunately, There Are No Customers At The Criff Bank.\n" +
		                        "Will You Be The First To Create An Account?\n");
			return -1;
		}
		System.out.println("Select An Account To Transfer Funds Into: \n");
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i + 1) + ") " + customers.get(i).basicInfo());
		}
		
		int account = 0;
		System.out.print("Please Enter Your Selection: ");
		try {
			account = Integer.parseInt(scan.nextLine()) -1;
		} catch(NumberFormatException e){
			account = -1;
		}
		
		if(account < 0 || account > customers.size()) {
			System.out.println("Invalid Account Selected.");
			account = -1;
		}
		
		return 0;
	}


	private void makeWithdrawal() {
		int account = selectAccount();
		if(account >= 0) {
			
			System.out.print("How Much Do You Want To Withdrawal? ");
			double amount = 0;
			try {
				amount = Double.parseDouble(scan.nextLine());
			} catch(NumberFormatException e){
				amount = 0;
			}
			
			bank.getCustomers(account).getAccount().withdrawal(amount);
		}
		
	}
	
	private void makeTransfer() {
		int account = selectTransferAccount();
		int account2 = selectTransferAccount2();
		if (account <= 0) {
			
			System.out.print("How Much Do You Want To Transfer To Account: ?" + this.selectAccount());
			double amount = 0;
			try {
				amount = Double.parseDouble(scan.nextLine());
			} catch(NumberFormatException e){
				amount = 0;
			}
			
			
//			bank.getCustomers(account).getAccount().withdrawal(amount);
//			this.bank.getCustomers(account).getAccount().deposit(amount);
//			acct1.transfer(acct2, amount);
//			this.makeWithdrawal();
			
//			System.out.print("Which Account Do You Want To Transfer " + "$" + df2.format(amount) + " To? ");
//			int account2 = selectTransferAccount2();
//			
//			
			
			
			
//			makeWithdrawal();
//	        makeDeposit();
	        System.out.println("\nTransfer succesful. Tansfered: $" + df2.format(amount));
	    } else { //does not need to be else if, because if not <=, it MUST be >.
	        System.out.println("\nTransfer failed, not enough balance!");
	    }
				
			}



	private void checkBalance() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println(bank.getCustomers(account).getAccount());
			}
			
			
		}
		
	private void denyAccount() {
		System.out.println("An Employee Has Decided To Deny Your Account!");
		
	}

	private void approveAccount() {
		String approveAccount = "";
		boolean valid = false;
		int account = selectAccount();
		while (!valid) {
			System.out.print("Which Account Would You Like To Approve?:");
			System.out.println(bank.getCustomers(account).getAccount());
			
			approveAccount = scan.nextLine();
			if(approveAccount.equalsIgnoreCase("yes") || approveAccount.equalsIgnoreCase("no")) {
				valid = true;				
			}
			else {
				System.out.println("No Account Was Selected. Please Select An Account To Approve. ");
			}		
	}	
} // end of approve account()
	
	private void canelAccount() {
		//Close the account
		balance = 0;
	 			
			}

	private void editInfo() {
				// TODO Auto-generated method stub
				
			}

} // end of menu class
