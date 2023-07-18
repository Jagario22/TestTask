package com.example.analyzer;

import java.util.List;

public interface WordAnalyzer {
    /**
     * Finds the first unique characters in the given array of words.
     *
     * @param words the array of words to analyze
     * @return the list of unique characters
     */
    List<Character> findFirstUniqueCharInWords(String[] words);
}
