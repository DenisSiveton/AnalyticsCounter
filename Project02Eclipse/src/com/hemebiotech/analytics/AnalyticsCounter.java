package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class is the main process for extracting and counting the different symptoms and writing the data in the result.out file
 */
public class AnalyticsCounter {

	public static void main(String[] args) {
		//determine the input and output files path
		String inputFilePath = "symptoms.txt";
		String outputFilePath = "result.out";

		ISymptomReader readSymptom = new ReadSymptomDataFromFile(inputFilePath);
		ISymptomWriter writer = new WriteSymptomDataToResultFile();
		ISymptomCounter countSymptom = new CountSymptomFromList((ArrayList<String>) readSymptom.getSymptoms());


		Map<String, Integer> mapSymptom = countSymptom.countSymptoms();
		writer.writeSymptoms(outputFilePath, mapSymptom);
	}
}
