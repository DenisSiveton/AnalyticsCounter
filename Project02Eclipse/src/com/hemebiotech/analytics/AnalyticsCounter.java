package com.hemebiotech.analytics;

import java.util.ArrayList;

/**
 * This class is the main process for extracting and counting the different symptoms and writing the data in the result.out file
 */
public class AnalyticsCounter {

	public static void main(String[] args) {
		// first get input via the filepath
		String filepath = "symptoms.txt";

		//STEP 1 : Create a class that will read the file and create a list with all the symptoms
		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile(filepath);

		//STEP 2 : Create a class writer that we will use to write in the output file.
		WriteSymptomDataToResultFile writer = new WriteSymptomDataToResultFile();

		// STEP 3 : Create a class that will sort the symptom list.
		CountSymptomFromList countSymptom = new CountSymptomFromList(writer, (ArrayList<String>) readSymptom.getSymptoms());

		//STEP 4 : Count and write all the symptom in the output file.
		countSymptom.countSymptoms();
	}
}
