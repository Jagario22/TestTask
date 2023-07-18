package com.example.analyzer;

/**
 * The TextAnalyzer interface provides methods for analyzing text and finding the first unique character.
 */
public interface TextAnalyzer {
    /**
     * Finds the first unique character in the given text.
     *
     * @param text the text to analyze
     * @return the first unique character, or '\0' if no unique character is found
     */
    char findFirstUniqueCharacter(String text);
}