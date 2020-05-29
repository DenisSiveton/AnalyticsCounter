package com.hemebiotech.analytics;

import java.util.Map;

/**
 *
 * Anything that will write symptom data to a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 */
public interface ISymptomWriter {

    void writeSymptoms(String filepath, Map<String, Integer> mapSymptomOccurrence);
}
