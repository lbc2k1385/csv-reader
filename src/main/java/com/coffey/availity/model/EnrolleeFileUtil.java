package com.coffey.availity.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Class is meant to serve as a utility for operations on Enrollee data found in CSVFile
 * 
 * @author Lucas Coffey
 *
 */
public class EnrolleeFileUtil {

	/**
	 * Will take in a String[] that is meant to represent 1 record inside of a CSV File
	 * and return a new Enrollee object from it.
	 * 
	 * @param record
	 * @return
	 */
	public Enrollee createNewEnrollee(String[] record) {
		
		   String userId = record[0];
		   String versionStr = record[2];
		   int version = Integer.parseInt(versionStr);
		   String insuranceCompany = record[3];
		   
		   String[] nameSplit = StringUtils.split(record[1]);  
		   String firstName = nameSplit[0];
		   String lastName = nameSplit[1];
		   
		   Enrollee newEnrollee = new Enrollee(userId, firstName, lastName, version, insuranceCompany);
		   
		   return newEnrollee;
	}
	
	/**
	 * Will place a new enrollee inside of a Map<String, Enrollee>, where the key is the user id.
	 * If user id already exist in map, then the value is updated.
	 * If user id does not exist in map, then a new entry will be created.
	 * The updated map will be returned.
	 * 
	 * @param newEnrollee
	 * @param enrolleMap
	 * @return
	 */
	public Map<String, Enrollee> createNewEnrolleeMap(Enrollee newEnrollee, Map<String, Enrollee> enrolleeMap) {

		/*
		 * If enrollee map doesn't exist yet then create new one.
		 * This should only occur when a new insurance company is found
		 * in the csv file, and has yet to create a map of enrollees.
		 */
	   if(enrolleeMap == null) {
		   enrolleeMap = new HashMap<String,Enrollee>();	   
		   enrolleeMap.put(newEnrollee.getUserId(), newEnrollee);
	   }else {
		   
		   //Get enrollee to update
		   Enrollee enrollee = enrolleeMap.get(newEnrollee.getUserId());	
		   
		   if(enrollee == null) {
			   enrolleeMap.put(newEnrollee.getUserId(), newEnrollee);
		   }else if(newEnrollee.getVersion() > enrollee.getVersion()) {
			   enrolleeMap.put(newEnrollee.getUserId(), newEnrollee);
		   }
	   }
		   
		return enrolleeMap;
	}
	
}
