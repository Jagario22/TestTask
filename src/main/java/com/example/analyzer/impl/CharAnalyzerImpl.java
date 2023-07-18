package com.example.analyzer.impl;

import com.example.analyzer.CharAnalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The CharAnalyzer class provides methods for analyzing characters and finding the first unique character.
 */
public class CharAnalyzerImpl implements CharAnalyzer {
    public char findFirstUniqueCharacterFromList(List<Character> characters) {
        Map<Character, Integer> characterCounts = new HashMap<>();

        for (Character character : characters) {
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }

        for (Character character : characters) {
            if (characterCounts.get(character) == 1) {
                return character;
            }
        }

        return '\0';
    }
}
