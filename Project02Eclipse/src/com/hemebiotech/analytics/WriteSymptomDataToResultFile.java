package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class, implemented from ISymptomWriter,  is used to write in a file the amount of times a symptom occurred as follows :
 *    "Symptom = Occurence"
 */
public class WriteSymptomDataToResultFile implements ISymptomWriter{

    /**
     *
     * @param filepath symptom that will be added to the output file
     * @param mapSymptomOccurrence times the symptom occurred
     *
     * This method will write in the output file the following line:
     *    " symptom = occurrence "
     */
    @Override
    public void writeSymptoms(String filepath, Map<String, Integer> mapSymptomOccurrence) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filepath);
            writer.write("List of symptom and occurence\n\n");
            for (Map.Entry<String, Integer> symptom : mapSymptomOccurrence.entrySet()) {
                writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if (writer !=null) {
                try {
                writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
