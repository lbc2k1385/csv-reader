package com.coffey.availity.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
	
	InputValidator validator = new InputValidator();

	@Test
	void isValidTest_NullCheck_False() {

		boolean result = validator.isValid(null);	
		
		assertFalse(result,"Input should not be null");
		
	}
	
	@Test
	void isValidTest_MultipleArguments_False() {
		
		String[] input = new String[2];
		
		input[0] = "()";
		input[1] = "";
		
		boolean result = validator.isValid(input);	
		
		assertFalse(result,"Input should not contain more than 1 arguement");
		
	}
	
	@Test
	void isValidTest_OneArguement_True() {
		
		String[] input = new String[1];
		
		input[0] = "()";
		
		boolean result = validator.isValid(input);	
		
		assertTrue(result);
		
	}

}
