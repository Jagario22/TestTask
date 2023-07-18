package com.example.analyzer;

import com.example.analyzer.impl.CharAnalyzerImpl;
import com.example.analyzer.impl.TextAnalyzerImpl;
import com.example.analyzer.impl.WordAnalyzerImpl;
import com.example.counter.CharacterCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextAnalyzerImplTest {
    private TextAnalyzer uniqueCharFinder;

    private WordAnalyzer wordAnalyzer;

    private CharAnalyzer charAnalyzer;

    @BeforeEach
    void setUp() {
        wordAnalyzer = new WordAnalyzerImpl(new CharacterCounter());
        charAnalyzer = new CharAnalyzerImpl();
        uniqueCharFinder = new TextAnalyzerImpl(wordAnalyzer, charAnalyzer);
    }

    @Test
    public void testFindFirstUniqueCharacter_SingleUniqueCharacter() {
        String text = "abcde";
        char expected = 'a';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_MultipleUniqueCharacters() {
        String text = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";
        char expected = 'm';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_NoUniqueCharacter() {
        String text = "aabbccddee";
        char expected = '\0';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_EmptyString() {
        String text = "";
        char expected = '\0';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_SingleWordWithUniqueCharacter() {
        String text = "hello";
        char expected = 'h';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_SingleWordWithNoUniqueCharacter() {
        String text = "aabbccddee";
        char expected = '\0';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_MultipleWordsWithUniqueCharacter() {
        String text = "The quick brown fox jumps over the lazy dog";
        char expected = 'T';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_MultipleWordsWithNoUniqueCharacter() {
        String text = "Hello world! Hello world!";
        char expected = '\0';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstUniqueCharacter_TestText() {
        String text = "C makes it easy for you to shoot yourself in the foot. C++ makes that harder, " +
                "but when you do, it blows away your whole leg. (с) Bjarne Stroustrup";
        char expected = 'e';
        char result = uniqueCharFinder.findFirstUniqueCharacter(text);

        Assertions.assertEquals(expected, result);
    }
}