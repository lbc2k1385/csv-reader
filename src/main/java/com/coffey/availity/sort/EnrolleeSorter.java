package com.coffey.availity.sort;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coffey.availity.model.Enrollee;

/**
 * Class is meant for sorting enrollees for each insurance company.
 * 
 * @author Lucas Coffey
 *
 */
public class EnrolleeSorter {

	/**
	 * Will iterate over map of enrollees for each insurance company and sort
	 * enrollees by last name, first name for each company and return a sorted list.
	 *
	 * @param insuranceMap
	 * @return
	 */
	public Map<String, List<Enrollee>> sortMap(Map<String, Map<String, Enrollee>> insuranceMap) {
		
		Map<String,List<Enrollee>> sortedMap = new HashMap<String, List<Enrollee>>();
			 
		insuranceMap.entrySet().stream().forEach( insuranceCompany -> {
			
			Map<String, Enrollee> insuranceCompanyMap = insuranceCompany.getValue();
			
			List<Enrollee> list = new ArrayList<Enrollee>(insuranceCompanyMap.values());
		
			Comparator<Enrollee> comparator = Comparator.comparing(Enrollee::getLastName).thenComparing(Enrollee::getFirstName);
			
			list.sort(comparator);
		
			sortedMap.put(insuranceCompany.getKey(), list);
		});
		
		return sortedMap;
	}
}
