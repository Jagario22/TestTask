package com.example.runner;

import com.example.analyzer.TextAnalyzer;

import java.util.Scanner;

/**
 * The ConsoleAppRunner class is responsible for running the console-based application that interacts with the user
 * and performs text analysis using the provided TextAnalyzer implementation.
 */
public class ConsoleAppRunner implements AppRunner {
    private final Scanner scanner;
    private final TextAnalyzer textAnalyzer;

    /**
     * Constructs a ConsoleAppRunner object with the given Scanner and TextAnalyzer instances.
     *
     * @param scanner      the Scanner object for user input
     * @param textAnalyzer the TextAnalyzer implementation for text analysis
     */
    public ConsoleAppRunner(Scanner scanner, TextAnalyzer textAnalyzer) {
        this.scanner = scanner;
        this.textAnalyzer = textAnalyzer;
    }

    /**
     * Runs the console application, allowing the user to enter text and perform text analysis.
     * The application continues running until the user enters 'exit'. When the user enters '\done',
     * the entered text will be processed and the result will be displayed.
     */
    @Override
    public void run() {
        String line;
        StringBuilder textBuilder;
        char firstUniqueCharacter;
        while (true) {
            System.out.print("Enter the text (type 'exit' to exit, type \"\\done\" to get result): ");
            line = scanner.nextLine();
            textBuilder = new StringBuilder();
            if (line.equalsIgnoreCase("exit")) {
                stop();
                break;
            }

            while (!line.equals("\\done")) {
                textBuilder.append(line).append("\n");
                line = scanner.nextLine();
            }
            firstUniqueCharacter = textAnalyzer.findFirstUniqueCharacter(textBuilder.toString());

            System.out.println("First unique character: " + firstUniqueCharacter);
            System.out.println();
        }
    }

    private void stop() {
        System.out.println("Program shutdown");
    }
}
