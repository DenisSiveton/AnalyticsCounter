package com.hemebiotech.analytics;

import java.util.Map;

/**
 *
 * Anything that will write symptom data to an output source
 * The important part is, there is no longer duplications in the symptoms and all of them are accounted for.
 *
 */
public interface ISymptomWriter {

    /**
     *
     * Write the data in the output file as requested
     *
     */
    void writeSymptoms(String filepath, Map<String, Integer> mapSymptomOccurrence);
}
