package com.coffey.availity.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.coffey.availity.model.Enrollee;
import com.coffey.availity.model.EnrolleeFileUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Class is used to read data and perform operations with CSVFile.
 * 
 * @author Lucas Coffey
 *
 */
public class FileParser {

	/**
	 * Will use a CSVReader to traverse file and create a Map<String,Map<String,Enrollee>>
	 * that will represent the list of enrollees for each insurance company.
	 * 
	 * @param csvReader
	 * @return
	 * @throws IOException
	 * @throws CsvValidationException
	 */
	public Map<String,Map<String,Enrollee>>  parseFile(CSVReader csvReader) throws IOException, CsvValidationException {
		
		//Local Variables
		Map<String,Map<String,Enrollee>> insuranceMap = new HashMap<String,Map<String,Enrollee>>();
		EnrolleeFileUtil util = new  EnrolleeFileUtil();
		String[] values = null;
			
		while ((values = csvReader.readNext()) != null) {
					   
		   Enrollee newEnrollee = util.createNewEnrollee(values);
		   
		   Map<String,Enrollee> enrolleMap = insuranceMap.get(newEnrollee.getInsuranceCompany());
		    
		   enrolleMap = util.createNewEnrolleeMap(newEnrollee, enrolleMap);
		   
		   insuranceMap.put(newEnrollee.getInsuranceCompany(), enrolleMap);
		}
		
		return insuranceMap;
	}
		
}
