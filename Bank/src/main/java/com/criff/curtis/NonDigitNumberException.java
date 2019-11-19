package com.criff.curtis;

import java.util.InputMismatchException;

public class NonDigitNumberException extends InputMismatchException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonDigitNumberException(String message){ // you can pass in your own message
        super(message);
        
        //message = "Invalid Choice. Please Enter Numeric Values Only!";
    }

    public NonDigitNumberException(){ // or use the default message
        super("input is not a digit");
    }
}
