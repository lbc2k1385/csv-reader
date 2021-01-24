package com.coffey.availity.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.coffey.availity.model.Enrollee;
import com.coffey.availity.model.EnrolleeFileUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FileParserTest {
	
	FileParser parser = new FileParser();
	public final String BLUE_CROSS= "Blue Cross";

	@Test
	void parseFileTest() throws CsvValidationException, IOException {
	
		//Locals Vars	
		Map<String,Map<String,Enrollee>> expectedReturnValue = new HashMap<String,Map<String,Enrollee>>();
		Map<String,Enrollee> expectedEnrolleeMap = new HashMap<String, Enrollee>();
		String[] record = createCSVRecord();	
		Enrollee e1 = new Enrollee("A123","Bruce","Wayne",1,BLUE_CROSS);
		
		CSVReader reader = createMocks(record, e1);	
		
		expectedEnrolleeMap.put("A123", e1);	
		expectedReturnValue.put(BLUE_CROSS, expectedEnrolleeMap);
	
		Map<String,Map<String,Enrollee>> result = parser.parseFile(reader);
		
		expectedEnrolleeMap.get(BLUE_CROSS);
		
		Map<String,Enrollee> resultInsuranceCompany= result.get(BLUE_CROSS);
		Enrollee resultEnrollee = resultInsuranceCompany.get("A123");
		
		
		verifyResults(e1, resultEnrollee);

	}

	private void verifyResults(Enrollee e1, Enrollee resultEnrollee) {
		assertEquals(e1.getUserId(), resultEnrollee.getUserId());
		assertEquals(e1.getFirstName(), resultEnrollee.getFirstName());
		assertEquals(e1.getLastName(), resultEnrollee.getLastName());
		assertEquals(e1.getVersion(), resultEnrollee.getVersion());
	}

	private CSVReader createMocks(String[] record, Enrollee e1) throws CsvValidationException, IOException {
		
		CSVReader reader = Mockito.mock(CSVReader.class);
		EnrolleeFileUtil util = Mockito.mock(EnrolleeFileUtil.class);
		
		Mockito.when(util.createNewEnrollee(record)).thenReturn(e1);
		Mockito.when(reader.readNext()).thenReturn(record).thenReturn(null);
		
		return reader;
	}

	private String[] createCSVRecord() {
		String[] record = new String[4];
		record[0] = "A123";
		record[1] = "Bruce Wayne";
		record[2] = "1";
		record[3] = "Blue Cross";
		return record;
	}

}
