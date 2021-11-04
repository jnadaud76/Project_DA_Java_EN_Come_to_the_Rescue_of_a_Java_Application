package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomToFile implements ISymptomWriter {
	/**
	 * A map of Symptoms.
	 * 
	 * @see WriteSymptomToFile#WriteSymptomToFile(Map)
	 */
	private Map<String, Integer> fileMap;

	/**
	 * WriteSymptomToFile constructor
	 * 
	 * @param fileMap a map of all Symptoms obtained from a List with no duplication
	 *                classify by alphabetical order. Each symptom will be
	 *                associated with a counter indicating the number of times it
	 *                appears in the map. Key parameter in Map represent Symptom.
	 *                Value parameter in Map represent counter.
	 * 
	 * @see WriteSymptomToFile#fileMap
	 */

	public WriteSymptomToFile(Map<String, Integer> fileMap) {
		this.fileMap = fileMap;
	}

	/**
	 * Write all elements contain in fileMap in a file.txt. Return nothing.
	 * 
	 */
	@Override
	public void writeSymptoms() {
		try {
			FileWriter writer = new FileWriter("result.out");
			for (Map.Entry<String, Integer> e : fileMap.entrySet()) {
				writer.write(e.getKey() + " : " + e.getValue() + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
