package com.coffey.availity.validator;

/**
 * This validator is intended to check the validity of the argument 
 * being passed into the program.
 * 
 * @author Lucas Coffey
 *
 */
public class InputValidator {
	
	/**
	 * Will return true if String[] is exactly 1 argument.
	 * If it is not exactly 1 argument, an error message will be displayed, 
	 * and the return value will be false.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isValid(String[] args) {
		
		boolean result = true;
		
		if(args == null || args.length != 1) {
			System.out.println("Please provide a path file."); 
			result = false;
		}
		
		return result;
	}

}
