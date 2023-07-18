package com.example.counter;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The CharacterCounter class provides methods for counting characters in a word.
 */
public class CharacterCounter {
    /**
     * Counts the occurrences of each character in the given word.
     *
     * @param word the word to count characters in
     * @return a map containing character counts
     */
    public Map<Character, Integer> countCharacters(String word) {
        Map<Character, Integer> characterCounts = new LinkedHashMap<>();
        for (char c : word.trim().toCharArray()) {
            characterCounts.put(c, characterCounts.getOrDefault(c, 0) + 1);
        }
        return characterCounts;
    }
}