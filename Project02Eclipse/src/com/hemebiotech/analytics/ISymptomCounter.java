package com.hemebiotech.analytics;


import java.util.Map;

/**
 *
 * Anything that will count symptom data from a source.
 * The important part is, the return value from the operation, which is a map <String, Integer> consisting
 * in Symptom and Occurrence.
 *
 */
public interface ISymptomCounter {

    /**
     *
     * @return a sorted map of all Symptoms and their respective occurrence.
     */
    Map<String, Integer> countSymptoms();
}
