package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class, implemented from ISymptomWCounter,  is used to count the amount of times a symptom occurred and place the following data
 * in a TreeMap<String, Integer> as follows:
 *    key --> Symptom
 *    value --> Occurrence
 */
public class CountSymptomFromList implements ISymptomCounter{

    private final List<String> sortedSymptomList;


    public CountSymptomFromList(List<String> symptomList) {
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
