package com.example.analyzer;

import com.example.analyzer.impl.WordAnalyzerImpl;
import com.example.counter.CharacterCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class WordAnalyzerImplTest {
    @Mock
    private CharacterCounter characterCounter;

    private WordAnalyzer wordAnalyzer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wordAnalyzer = new WordAnalyzerImpl(characterCounter);
    }

    @Test
    public void testFindFirstUniqueCharInWords_SingleWordWithUniqueCharacter() {
        String[] words = {"hello"};

        Map<Character, Integer> characterCounts = new HashMap<>();
        characterCounts.put('h', 1);
        characterCounts.put('e', 1);
        characterCounts.put('l', 2);
        characterCounts.put('o', 1);

        when(characterCounter.countCharacters("hello")).thenReturn(characterCounts);

        List<Character> expected = new ArrayList<>();
        expected.add('h');

        List<Character> result = wordAnalyzer.findFirstUniqueCharInWords(words);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharInWords_SingleWordWithNoUniqueCharacter() {
        String[] words = {"aabbcdcdee"};

        Map<Character, Integer> characterCounts = new HashMap<>();
        characterCounts.put('a', 2);
        characterCounts.put('b', 2);
        characterCounts.put('c', 2);
        characterCounts.put('d', 2);
        characterCounts.put('e', 2);

        when(characterCounter.countCharacters("aabbcdcdee")).thenReturn(characterCounts);

        List<Character> expected = new ArrayList<>();

        List<Character> result = wordAnalyzer.findFirstUniqueCharInWords(words);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharInWords_MultipleWordsWithUniqueCharacter() {
        String[] words = {"The", "quick", "brown", "fox"};

        Map<Character, Integer> characterCounts1 = new HashMap<>();
        characterCounts1.put('T', 1);
        characterCounts1.put('h', 1);
        characterCounts1.put('e', 1);

        Map<Character, Integer> characterCounts2 = new HashMap<>();
        characterCounts2.put('q', 1);
        characterCounts2.put('u', 1);
        characterCounts2.put('i', 1);
        characterCounts2.put('c', 1);
        characterCounts2.put('k', 1);

        Map<Character, Integer> characterCounts3 = new HashMap<>();
        characterCounts3.put('b', 1);
        characterCounts3.put('r', 1);
        characterCounts3.put('o', 1);
        characterCounts3.put('w', 1);
        characterCounts3.put('n', 1);

        Map<Character, Integer> characterCounts4 = new HashMap<>();
        characterCounts4.put('f', 1);
        characterCounts4.put('o', 1);
        characterCounts4.put('x', 1);

        when(characterCounter.countCharacters("The")).thenReturn(characterCounts1);
        when(characterCounter.countCharacters("quick")).thenReturn(characterCounts2);
        when(characterCounter.countCharacters("brown")).thenReturn(characterCounts3);
        when(characterCounter.countCharacters("fox")).thenReturn(characterCounts4);

        List<Character> expected = new ArrayList<>();
        expected.add('T');
        expected.add('q');
        expected.add('b');
        expected.add('f');

        List<Character> result = wordAnalyzer.findFirstUniqueCharInWords(words);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharInWords_MultipleWordsWithNoUniqueCharacter() {
        String[] words = {"Hello", "world!", "Hello", "world!"};

        Map<Character, Integer> characterCounts1 = new HashMap<>();
        characterCounts1.put('H', 1);
        characterCounts1.put('e', 1);
        characterCounts1.put('l', 2);
        characterCounts1.put('o', 1);

        Map<Character, Integer> characterCounts2 = new HashMap<>();
        characterCounts2.put('w', 1);
        characterCounts2.put('o', 1);
        characterCounts2.put('r', 1);
        characterCounts2.put('l', 1);
        characterCounts2.put('d', 1);

        when(characterCounter.countCharacters("Hello")).thenReturn(characterCounts1);
        when(characterCounter.countCharacters("world!")).thenReturn(characterCounts2);

        List<Character> expected = new ArrayList<>();
        expected.add('H');
        expected.add('w');
        expected.add('H');
        expected.add('w');

        List<Character> result = wordAnalyzer.findFirstUniqueCharInWords(words);

        Assertions.assertEquals(expected, result);
    }
}
