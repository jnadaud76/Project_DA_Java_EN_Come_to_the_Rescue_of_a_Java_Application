package com.hemebiotech.analytics;

/**
 * <b>Analytics Counter</b>
 * <p>
 * The purpose of this application is to :
 * <ul>
 * <li>Read data from a file</li>
 * <li>Count the number of occurrences of each entry and organize them</li>
 * <li>Write the result in other file</li>
 * </ul>
 * </p>
 * 
 * @see ReadSymptomDataFromFile#getSymptoms()
 * @see CountSymptomFromList#countSymptoms()
 * @see WriteSymptomToFile#writeSymptoms()
 * 
 * 
 * @author Johan Nadaud
 * @version 0.9
 *
 */

public class AnalyticsCounter {
	private static final String inputFile = "symptoms.txt";

	public static void main(String args[]) throws Exception {

		ISymptomReader reader = new ReadSymptomDataFromFile(inputFile);
		ISymptomCounter counter = new CountSymptomFromList(reader.getSymptoms());
		ISymptomWriter writer = new WriteSymptomToFile(counter.countSymptoms());
		writer.writeSymptoms();
	}
}