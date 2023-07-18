package com.example.analyzer.impl;

import com.example.analyzer.CharAnalyzer;
import com.example.analyzer.TextAnalyzer;
import com.example.analyzer.WordAnalyzer;

import java.util.List;

/**
 * The TextAnalyzerImpl class implements the TextAnalyzer interface and provides methods for analyzing text and finding
 * the first unique character.
 */
public class TextAnalyzerImpl implements TextAnalyzer {
    private final WordAnalyzer wordAnalyzer;
    private final CharAnalyzer charAnalyzer;

    public TextAnalyzerImpl(WordAnalyzer wordAnalyzerImpl, CharAnalyzer charAnalyzer) {
        this.wordAnalyzer = wordAnalyzerImpl;
        this.charAnalyzer = charAnalyzer;
    }

    @Override
    public char findFirstUniqueCharacter(String text) {
        List<Character> uniqueCharactersFromText = wordAnalyzer
                .findFirstUniqueCharInWords(text.replaceAll("[^a-zA-Z\\s]", "")
                        .split("\\s+"));
        return charAnalyzer.findFirstUniqueCharacterFromList(uniqueCharactersFromText);
    }
}