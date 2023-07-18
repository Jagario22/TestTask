package com.example.analyzer;

import com.example.counter.CharacterCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CharacterCounterTest {
    private CharacterCounter characterCounter;

    @BeforeEach
    void setUp() {
        characterCounter = new CharacterCounter();
    }

    @Test
    public void testCountCharacters_SingleCharacterWord() {
        String word = "a";
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> result = characterCounter.countCharacters(word);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCountCharacters_MultipleCharacterWord() {
        String word = "hello";
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 1);

        Map<Character, Integer> result = characterCounter.countCharacters(word);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCountCharacters_WordWithSpaces() {
        String word = "  hello  ";
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 1);

        Map<Character, Integer> result = characterCounter.countCharacters(word);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCountCharacters_EmptyWord() {
        String word = "";
        Map<Character, Integer> expected = new HashMap<>();

        Map<Character, Integer> result = characterCounter.countCharacters(word);

        Assertions.assertEquals(expected, result);
    }
}