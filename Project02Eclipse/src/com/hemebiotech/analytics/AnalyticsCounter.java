package com.hemebiotech.analytics;

public class AnalyticsCounter {
	private static final String inputFile = "symptoms.txt";

	public static void main(String args[]) throws Exception {

		ISymptomReader reader = new ReadSymptomDataFromFile(inputFile);
		ISymptomCounter counter = new CountSymptomFromList(reader.getSymptoms());
		ISymptomWriter writer = new WriteSymptomToFile(counter.countSymptoms());
		writer.writeSymptoms();

	}
}