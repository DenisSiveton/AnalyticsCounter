package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is used to write in a file the amount of times a symptom occurred as follows :
 *    "Symptom = Occurence"
 */
public class WriteSymptomDataToResultFile implements ISymptomWriter{

    //methods

    /**
     * This method just a specific title in the output file.
     */
    @Override
    public void writeTitle(){
        try {
            FileWriter writer = new FileWriter ("result.out");
            writer.write("List of symptom and occurence\n\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param symptom symptom that will be added to the output file
     * @param occurrence times the symptom occurred
     *
     * This method will write in the output file the following line:
     *    " symptom = occurrence "
     */
    @Override
    public void writeSymptoms(String symptom, int occurrence) {

        try {
            FileWriter writer = new FileWriter ("result.out");
            writer.write(symptom + " = " + occurrence +"\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
