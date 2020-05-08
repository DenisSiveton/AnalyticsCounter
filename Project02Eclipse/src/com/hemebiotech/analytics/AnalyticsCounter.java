package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input via the filepath
		String filepath = "symptoms.txt";

		//Create a class that will read the file and create a list

		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile(filepath);

		//Create a class that will sort the symptom list and write all the occurence in the output file.

		WriteSymptomDataToResultFile writeSymptom = new WriteSymptomDataToResultFile((ArrayList<String>) readSymptom.GetSymptoms());
	}

}
