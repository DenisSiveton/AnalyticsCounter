package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This class is the main process for extracting and counting the different symptoms and writing the data in the result.out file
 */
public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input via the filepath
		String filepath = "symptoms.txt";

		//Create a class that will read the file and create a list with all the symptoms

		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile(filepath);

		//Create a class that will sort the symptom list and write all the occurence in the "result.out" file.

		WriteSymptomDataToResultFile writeSymptom = new WriteSymptomDataToResultFile((ArrayList<String>) readSymptom.GetSymptoms());
	}

}
