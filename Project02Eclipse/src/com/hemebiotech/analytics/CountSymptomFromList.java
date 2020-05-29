package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class CountSymptomFromList implements ISymptomCounter{

    private final ArrayList<String> sortedSymptomList;


    public CountSymptomFromList(ArrayList<String> symptomList) {
        Collections.sort(symptomList);
        this.sortedSymptomList = symptomList;
    }

    /**
     * This method will count for each symptom the amount of time it occurred.
     * I will also return a Map <String, Integer> equivalent to <Symptom, Occurence>
     *
     */
    @Override
    public Map<String, Integer> countSymptoms() {

        int occurrenceSymptom = 0;
        String currentSymptom = sortedSymptomList.get(0);

        Map<String, Integer> mapSymptomOccurrence = new TreeMap<>();
        for(String symptomToAnalyse : sortedSymptomList) {
            if (currentSymptom.equals(symptomToAnalyse)) {
                occurrenceSymptom += 1;
            }
            else {
                mapSymptomOccurrence.put(currentSymptom, occurrenceSymptom);
                currentSymptom = symptomToAnalyse;
                occurrenceSymptom = 1;
            }
        }
        return mapSymptomOccurrence;
    }
}
