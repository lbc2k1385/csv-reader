package com.coffey.availity.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.coffey.availity.model.Enrollee;

class EnrolleeSorterTest {

	public final static  String BLUE_CROSS = "Blue Cross";
	public final static String  TRICARE = "Tricare";
	
	@Test
	void sortMapTest() {
		
		Map<String, Map<String, Enrollee>> insuranceMap = createInsuranceMapOfMaps();
		Map<String, List<Enrollee>>  expectedResult = createExpectedResult();
		
		EnrolleeSorter sorter = new EnrolleeSorter();
		Map<String, List<Enrollee>> results = sorter.sortMap(insuranceMap);
		
		validateResults(expectedResult, results);
		
	}
	
	private void validateResults(Map<String, List<Enrollee>> expected, Map<String, List<Enrollee>> results) {
		
		expected.entrySet().stream().forEach(userId -> {
			assertEquals(expected.get(userId),results.get(userId));
		});
		
	}
	
	private Map<String, List<Enrollee>> createExpectedResult(){
		
		Map<String, List<Enrollee>> insuranceMap =  new HashMap<>();
		List<Enrollee> tricareEnrollees = new ArrayList<>();
		List<Enrollee> blueCrossEnrollees = new ArrayList<>();
		
		Enrollee e1 = new Enrollee("Ar123","Arya","Stark",1,"Tricare");
		Enrollee e2 = new Enrollee("Js123","Jon","Snow",1,"Tricare");
		tricareEnrollees.add(e1);
		tricareEnrollees.add(e2);
		
		Enrollee e3 = new Enrollee("sk123","Bart","Simpson",2,"Blue Cross");
		Enrollee e4 = new Enrollee("ls845","Lisa","Simpson",1,"Blue Cross");
		blueCrossEnrollees.add(e3);
		blueCrossEnrollees.add(e4);
		
		
		insuranceMap.put("Tricare", tricareEnrollees);
		insuranceMap.put("Blue Cross", blueCrossEnrollees);
		
		
		return insuranceMap;
	}

	private Map<String, Map<String, Enrollee>> createInsuranceMapOfMaps() {
		
		Map<String, Map<String, Enrollee>> insuranceMap = new HashMap<String, Map<String,Enrollee>>();
		Map<String, Enrollee> tricareEnrollees = new HashMap<String, Enrollee>();
		Map<String, Enrollee> blueCrossEnrollees = new HashMap<String, Enrollee>();
		
		Enrollee e1 = new Enrollee("Js123","Jon","Snow",1,TRICARE);
		Enrollee e2 = new Enrollee("Ar123","Arya","Stark",1,TRICARE);
		tricareEnrollees.put(TRICARE,e1);
		tricareEnrollees.put(TRICARE,e2);
		
		Enrollee e3 = new Enrollee("sk123","Bart","Simpson",1,BLUE_CROSS);
		Enrollee e4 = new Enrollee("sk123","Bart","Simpson",2,BLUE_CROSS);
		Enrollee e5 = new Enrollee("ls845","Lisa","Simpson",1,BLUE_CROSS);
		blueCrossEnrollees.put(BLUE_CROSS,e3);
		blueCrossEnrollees.put(BLUE_CROSS,e4);
		blueCrossEnrollees.put(BLUE_CROSS,e5);
		
		insuranceMap.put("Tricare", tricareEnrollees);
		insuranceMap.put("Blue Cross", blueCrossEnrollees);
		return insuranceMap;
	}

}
