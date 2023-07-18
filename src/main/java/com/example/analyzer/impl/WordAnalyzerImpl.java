package com.example.analyzer.impl;

import com.example.analyzer.WordAnalyzer;
import com.example.counter.CharacterCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The WordAnalyzer class provides methods for analyzing words and finding the first unique characters in words.
 */
public class WordAnalyzerImpl implements WordAnalyzer {
    private final CharacterCounter characterCounter;

    /**
     * Constructs a WordAnalyzer object with the given CharacterCounter instance.
     *
     * @param characterCounter the character counter implementation to use
     */
    public WordAnalyzerImpl(CharacterCounter characterCounter) {
        this.characterCounter = characterCounter;
    }

    public List<Character> findFirstUniqueCharInWords(String[] words) {
        List<Character> uniqueCharacters = new ArrayList<>();

        for (String word : words) {
            Map<Character, Integer> characterCounts = characterCounter.countCharacters(word);
            for (char c : word.trim().toCharArray()) {
                if (characterCounts.get(c) == 1) {
                    uniqueCharacters.add(c);
                    break;
                }
            }
        }

        return uniqueCharacters;
     }
}
