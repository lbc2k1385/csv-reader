package com.coffey.availity.output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.coffey.availity.model.Enrollee;
import com.opencsv.CSVWriter;

/**
 * Class is used for csv output operations.
 * 
 * @author Lucas Coffey
 *
 */
public class CSVOutputWriter{
	
	/**
	 * Will create a series of new csv file for each insurance company that has a list
	 * of enrollees for each company.  Enrollees are sorted by last name, first name.
	 * 
	 * @param insuranceMap
	 */
	public void createOutputFiles(Map<String, List<Enrollee>> insuranceMap) {
		
		insuranceMap.entrySet().forEach( (insuranceCompany) -> {
			
			String fileName = insuranceCompany.getKey() + ".csv";
	
			try(CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName))) {
				
				String[] records = "User_id,Name,Version,Insurance_Company".split(",");							
				
				csvWriter.writeNext(records);
				
				List<Enrollee> enrollees = insuranceCompany.getValue();
				
				enrollees.forEach(enrollee -> {
					writeEnrolleeRecord(csvWriter, enrollee);
				});

				
			} catch (IOException e) {
				System.out.println("Unable to create file: " + fileName);
			}

		});
	}

	/**
	 * Will write a record via csvWriter based on enrollee data.
	 * 
	 * @param csvWriter
	 * @param enrollee
	 */
	private void writeEnrolleeRecord(CSVWriter csvWriter, Enrollee enrollee) {
		
		String record = enrollee.getUserId() + "," + enrollee.getFirstName() + " " 
				+ enrollee.getLastName() +  "," + enrollee.getVersion() + "," 
				+ enrollee.getInsuranceCompany();
		
		String[] enrolleeRecord = record.split(",");
		
		csvWriter.writeNext(enrolleeRecord);
	}

}
