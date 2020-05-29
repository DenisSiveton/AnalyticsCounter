package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This class is the main process for extracting and counting the different symptoms and writing the data in the result.out file
 */
public class AnalyticsCounter {

	public List<String> read(String inputFilePath) {
		return new ReadSymptomDataFromFile(inputFilePath).getSymptoms();
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
