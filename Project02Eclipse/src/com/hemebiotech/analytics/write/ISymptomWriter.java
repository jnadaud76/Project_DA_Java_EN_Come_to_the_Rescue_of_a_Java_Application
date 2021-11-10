package com.hemebiotech.analytics.write;

import java.util.Map;

/**
 * Anything that will write symptom data from a source in something (file, data
 * base...).
 * 
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, return nothing.
	 * 
	 * @param fileMap a map of all Symptoms obtained from a List with no duplication
	 *                classify by alphabetical order. Each symptom will be
	 *                associated with a counter indicating the number of times it
	 *                appears in the map.
	 * 
	 */
	void writeSymptoms(Map<String, Integer> fileMap);
}
