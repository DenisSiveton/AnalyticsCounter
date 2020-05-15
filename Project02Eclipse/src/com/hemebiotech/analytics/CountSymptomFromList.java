package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;

public class CountSymptomFromList implements ISymptomCounter{

    //members

    private final ISymptomWriter writer;
    private final ArrayList<String> sortedSymptomList;

    //methods

    public CountSymptomFromList(ISymptomWriter writer, ArrayList<String> symptomList) {
        this.writer = writer;
        Collections.sort(symptomList);
        this.sortedSymptomList = symptomList;
    }

    /**
     * This method will count for each symptom the amount of time it occurred.
     * I will also write in the output file the data using the "WriteSymptomDataToFile" class
     */
    @Override
    public void countSymptoms() {

        int occurrenceSymptom = 0;
        String currentSymptom = sortedSymptomList.get(0);
        writer.writeTitle();
        for(String symptomToAnalyse : sortedSymptomList) {
            if (currentSymptom.equals(symptomToAnalyse)) {
                occurrenceSymptom += 1;
            }
            else {
                writer.writeSymptoms(symptomToAnalyse, occurrenceSymptom);
                currentSymptom = symptomToAnalyse;
                occurrenceSymptom = 1;
            }
        }
    }
}
