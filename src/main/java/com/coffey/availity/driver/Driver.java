package com.coffey.availity.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.coffey.availity.model.Enrollee;
import com.coffey.availity.output.CSVOutputWriter;
import com.coffey.availity.parser.FileParser;
import com.coffey.availity.sort.EnrolleeSorter;
import com.coffey.availity.validator.InputValidator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Program will take in 1 arguments that specifies the csv file to be processed.
 * Will parse the csv file, separate enrollees by insurance company,create output
 * files for each insurance company ,and sort the contents of each output file by
 * last name, first name.  Files will be written to project home directory.
 * 
 * @author Lucas Coffey
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		//Local Variables
		InputValidator inputValidator = new InputValidator();	
		FileParser parser = new FileParser();
		EnrolleeSorter sorter = new EnrolleeSorter();
		CSVOutputWriter writer = new CSVOutputWriter();
		Map<String,Map<String,Enrollee>> insuranceMap = null;
		
		if(!inputValidator.isValid(args))
			System.exit(0);
		
		try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(args[0])).withSkipLines(1).build();) {    
			insuranceMap = parser.parseFile(csvReader);	    
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " +  args[0]);
		} catch (IOException e) {
			System.out.println("Something occured when reading file");
		} catch (CsvValidationException e) {
			System.out.println("Something occured whith a validator");
		}
		
		Map<String, List<Enrollee>> sortedMap = sorter.sortMap(insuranceMap);
		
		writer.createOutputFiles(sortedMap);
		
	}


	
	
}
