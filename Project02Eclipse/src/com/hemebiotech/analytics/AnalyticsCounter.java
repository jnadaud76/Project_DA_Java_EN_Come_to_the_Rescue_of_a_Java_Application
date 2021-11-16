package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.analyse.Analyse;
import com.hemebiotech.analytics.count.CountSymptomFromList;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.write.WriteSymptomToFile;

/**
 * <b>Analytics Counter</b>
 * <p>
 * The purpose of this application is to :
 * </p>
 * <ul>
 * <li>Read data from a file</li>
 * <li>Count the number of occurrences of each entry and organize them</li>
 * <li>Write the result in other file</li>
 * </ul>
 * 
 * @see Analyse
 * @see ReadSymptomDataFromFile#getSymptoms
 * @see CountSymptomFromList#countSymptoms
 * @see WriteSymptomToFile#writeSymptoms
 * 
 * @author Johan Nadaud
 * @version 1.0
 *
 */
public class AnalyticsCounter {
	/**
	 * File path of input file. Cannot be change.
	 */
	private static final String inputFile = "symptoms.txt";
	/**
	 * File path of output file. Cannot be change.
	 */
	private static final String outputFile = "result.out";

	public static void main(String args[]) throws Exception {

		Analyse analyse = new Analyse(new ReadSymptomDataFromFile(inputFile), new CountSymptomFromList(),
				new WriteSymptomToFile(outputFile));

		List<String> listNotCounted = analyse.getSymptoms();
		Map<String, Integer> mapCountedAndSorted = analyse.countSymptoms(listNotCounted);
		analyse.writeSymptoms(mapCountedAndSorted);

	}
}