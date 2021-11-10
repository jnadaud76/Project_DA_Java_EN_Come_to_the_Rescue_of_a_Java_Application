package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count symptom from a List. The important part is, the
 * return value from the operation, which is a list of strings, doesn't contain
 * any duplication.
 * 
 * The implementation does need to order the list
 * 
 */
public interface ISymptomCounter {
	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return a map of all Symptoms obtained from a List with no duplication
	 *         classify by alphabetical order. Each symptom will be associated with
	 *         a counter indicating the number of times it appears in the map.
	 * @param fileList a raw listing of all Symptoms obtained from a file,
	 *                 duplicates are possible/probable
	 * 
	 */
	Map<String, Integer> countSymptoms(List<String> fileList);
}
