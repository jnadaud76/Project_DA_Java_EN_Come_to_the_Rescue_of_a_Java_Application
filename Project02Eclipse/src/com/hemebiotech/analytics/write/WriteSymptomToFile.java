package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomToFile implements ISymptomWriter {
	/**
	 * file path to data source.
	 *
	 */
	private String filePath;

	/**
	 * WriteSymptomToFile constructor
	 * 
	 * @param filePath the path to the file where the data will be written.
	 * 
	 */
	public WriteSymptomToFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Write all elements contain in fileMap in a output file. Return nothing.
	 * 
	 * @param fileMap a map of all Symptoms obtained from a List with no duplication
	 *                classify by alphabetical order. Each symptom will be
	 *                associated with a counter indicating the number of times it
	 *                appears in the map. Key parameter in Map represent Symptom.
	 *                Value parameter in Map represent counter.
	 * 
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> fileMap) {
		try {
			FileWriter writer = new FileWriter(filePath);
			for (Map.Entry<String, Integer> e : fileMap.entrySet()) {
				writer.write(e.getKey() + " : " + e.getValue() + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
