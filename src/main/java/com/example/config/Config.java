package com.example.config;

import com.example.analyzer.CharAnalyzer;
import com.example.analyzer.TextAnalyzer;
import com.example.analyzer.WordAnalyzer;
import com.example.analyzer.impl.CharAnalyzerImpl;
import com.example.analyzer.impl.TextAnalyzerImpl;
import com.example.analyzer.impl.WordAnalyzerImpl;
import com.example.counter.CharacterCounter;
import com.example.runner.AppRunner;
import com.example.runner.ConsoleAppRunner;

import java.util.Scanner;

public class Config {
    private Scanner scanner;
    private CharacterCounter characterCounter;
    private WordAnalyzerImpl wordAnalyzerImpl;
    private CharAnalyzerImpl charAnalyzerImpl;
    private TextAnalyzer textAnalyzer;
    private AppRunner appRunner;

    private TextAnalyzer getTextAnalyzer() {
        if (textAnalyzer == null) {
            textAnalyzer = new TextAnalyzerImpl(getWordAnalyzer(), getCharAnalyzer());
        }
        return textAnalyzer;
    }

    private CharAnalyzer getCharAnalyzer() {
        if (charAnalyzerImpl == null) {
            charAnalyzerImpl = new CharAnalyzerImpl();
        }
        return charAnalyzerImpl;
    }

    private WordAnalyzer getWordAnalyzer() {
        if (wordAnalyzerImpl == null) {
            wordAnalyzerImpl = new WordAnalyzerImpl(getCharCounter());
        }
        return wordAnalyzerImpl;
    }

    private CharacterCounter getCharCounter() {
        if (characterCounter == null) {
            characterCounter = new CharacterCounter();
        }
        return characterCounter;
    }

    private Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }

    public AppRunner getConsoleRunner() {
        if (appRunner == null) {
            appRunner = new ConsoleAppRunner(getScanner(), getTextAnalyzer());
        }

        return appRunner;
    }
}
