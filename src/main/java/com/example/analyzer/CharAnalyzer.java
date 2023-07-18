package com.example.analyzer;

import java.util.List;

public interface CharAnalyzer {
    /**
     * Finds the first unique character from the given list of characters.
     *
     * @param characters the list of characters to analyze
     * @return the first unique character, or '\0' if no unique character is found
     */
    char findFirstUniqueCharacterFromList(List<Character> characters);
}
