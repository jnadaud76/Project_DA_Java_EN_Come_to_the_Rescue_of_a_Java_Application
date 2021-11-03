package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomToFile implements ISymptomWriter {

	private TreeMap<String, Integer> fileMap;

	/**
	 * WriteSymptomToFile constructor
	 * 
	 * @param fileMap a map of all Symptoms obtained from a List with no duplication
	 *                classify by alphabetical order. Each symptom will be
	 *                associated with a counter indicating the number of times it
	 *                appears in the map. Key parameter in Map represent Symptom.
	 *                Value parameter in Map represent counter.
	 */

	public WriteSymptomToFile(TreeMap<String, Integer> fileMap) {
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
				writer.write(e.getKey() + " : " + e.getValue());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
