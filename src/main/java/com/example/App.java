package com.example;

import com.example.config.Config;
import com.example.runner.AppRunner;

public class App {
    public static void main(String[] args) {
        Config config = new Config();
        AppRunner appRunner = config.getConsoleRunner();
        appRunner.run();
    }
}
