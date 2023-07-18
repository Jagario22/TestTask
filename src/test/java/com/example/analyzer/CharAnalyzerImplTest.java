package com.example.analyzer;

import com.example.analyzer.impl.CharAnalyzerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharAnalyzerImplTest {
    private CharAnalyzer charAnalyzer;

    @BeforeEach
    void setUp() {
        charAnalyzer = new CharAnalyzerImpl();
    }

    @Test
    public void testFindFirstUniqueCharacterFromList_SingleUniqueCharacter() {
        List<Character> characters = new ArrayList<>();
        characters.add('a');

        char expected = 'a';
        char result = charAnalyzer.findFirstUniqueCharacterFromList(characters);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacterFromList_MultipleUniqueCharacters() {
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('b');
        characters.add('c');
        characters.add('d');

        char expected = 'a';
        char result = charAnalyzer.findFirstUniqueCharacterFromList(characters);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacterFromList_NoUniqueCharacter() {
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('a');
        characters.add('a');
        characters.add('a');

        char expected = '\0';
        char result = charAnalyzer.findFirstUniqueCharacterFromList(characters);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacterFromList_EmptyList() {
        List<Character> characters = new ArrayList<>();

        char expected = '\0';
        char result = charAnalyzer.findFirstUniqueCharacterFromList(characters);

        Assertions.assertEquals(expected, result);
    }
}