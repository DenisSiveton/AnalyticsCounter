package com.hemebiotech.analytics;

/**
 * Anything that will write symptom data to a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomWriter {

    void writeSymptoms(String symptom, int occurrence);
}
