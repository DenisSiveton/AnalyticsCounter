package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This class define the different methods needed for each step of the process.
 * 		1 - Read
 * 		2 - Count
 * 		3 - Write
 */
public class AnalyticsCounter {

	public List<String> read(String inputFilePath) {
		ISymptomReader readSymptom = new ReadSymptomDataFromFile(inputFilePath);
		return readSymptom.getSymptoms();
	}

	public Map<String, Integer> count(List<String> symptomsList) {
		ISymptomCounter countSymptom = new CountSymptomFromList(symptomsList);
		return countSymptom.countSymptoms();
	}

	public void write(String outputFilePath, Map<String, Integer> mapSymptoms) {
		ISymptomWriter writer = new WriteSymptomDataToResultFile();
		writer.writeSymptoms(outputFilePath, mapSymptoms);
	}


}
