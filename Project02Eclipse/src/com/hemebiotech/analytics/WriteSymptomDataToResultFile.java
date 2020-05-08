package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * From a list of symptoms "ArrayList<String>", it will count for each symptom its occurences.
 *
 * It will then write in the "result.out" file the difference occurences for each symptom as follows:
 *    "Symptom = Occurence"
 */
public class WriteSymptomDataToResultFile {

    //members
    private ArrayList<String> m_rawSymptomList;

    //methods

    /**
     *
     * @param symptomList a raw list of symptom with possible duplications
     * @throws IOException
     *
     * This constructor is receiving a raw symptom list as a parameter and will conduct the different methods to write the "result.out" file.
     */
    public WriteSymptomDataToResultFile (ArrayList<String> symptomList) throws IOException {
        this.m_rawSymptomList = symptomList;
        this.WriteSymptomInFile();
    }
    /**
     * From a raw list of symptoms "ArrayList<String>", it will sort alphabetically the different symptoms.
     *
     * It will then return the sorted list so that the symptoms can be counted properly.
     */
    public ArrayList<String> sortList(ArrayList<String> rawSymptomList){
        Collections.sort(rawSymptomList);
        return rawSymptomList;
    }

    /**
     * From a sorted list of symptoms "ArrayList<String>", it will remove all symptoms duplicates.
     *
     * It will then return the sorted list without any duplicates.
     */
    public <T> ArrayList<T> RemoveDuplicatesFromList(ArrayList<T> symptomListWithDuplicates){
        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(symptomListWithDuplicates);

        //Create new list
        ArrayList<T> symptomListNoDuplications = new ArrayList<>();

        // add the elements of set
        // with no duplicates to the list
        symptomListNoDuplications.addAll(set);

        // return the list
        return symptomListNoDuplications;
    }

    /**
     * From a raw list of symptoms, it will write in an output file "result.out" all the symptoms
     * and their occurence sorted alphabetically.
     */
    public void WriteSymptomInFile(){

        //Create the symptom list sorted
        ArrayList<String> sortedSymptomList = sortList(m_rawSymptomList);

        //Create the symptom list sorted without duplicates
        ArrayList<String> sortedSymptomListNoDuplications = RemoveDuplicatesFromList(m_rawSymptomList);

        try {
            FileWriter writer = new FileWriter ("result.out");
            writer.write("List of symptom and occurence\n\n");

            for(String symptomToAnalyse : sortedSymptomListNoDuplications) {
                int occurenceSymptom = 0;
                for (String symptomCount : m_rawSymptomList){
                    if (symptomToAnalyse.equals(symptomCount)) {
                        occurenceSymptom += 1;
                    }
                }
                writer.write(symptomToAnalyse + " = " + occurenceSymptom +"\n");
            }git
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
