package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class CountSymptomFromList implements ISymptomCounter {
	/**
	 * CountSymptomFromList constructor
	 * 
	 */
	public CountSymptomFromList() {

	}

	/**
	 * Return a listing of all Symptoms.
	 * 
	 * @return a map of all Symptoms obtained from a List with no duplication
	 *         classify by alphabetical order. Each symptom will be associated with
	 *         a counter indicating the number of times it appears in the map. Key
	 *         parameter in Map represent Symptom. Value parameter in Map represent
	 *         counter.
	 * @param fileList a raw listing of all Symptoms obtained from a file,
	 *                 duplicates are possible/probable
	 */
	@Override
	public Map<String, Integer> countSymptoms(List<String> fileList) {
		Map<String, Integer> result = new TreeMap<String, Integer>();

		if (fileList != null) {
			for (String symptom : fileList) {
				if (!result.containsKey(symptom)) {
					result.put(symptom, 1);
				} else {
					result.put(symptom, result.get(symptom) + 1);
				}
			}
		}
		return result;
	}
}
