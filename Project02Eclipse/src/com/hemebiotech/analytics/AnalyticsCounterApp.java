package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounterApp {

    public static void main (String[] args) {

        String inputFilePath = "symptoms.txt";
        String outputFilePath = "result.out";

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        List<String> symptomsList = analyticsCounter.read(inputFilePath);
        Map<String, Integer> mapSymptoms = analyticsCounter.count(symptomsList);
        analyticsCounter.write(outputFilePath,mapSymptoms);
    }
}
