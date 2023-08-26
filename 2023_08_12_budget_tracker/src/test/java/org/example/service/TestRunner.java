package org.example.service;

import java.io.IOException;

/**
 * @author Andrej Reutow
 * created on 26.08.2023
 */
public class TestRunner {

    protected static void init() throws IOException {
        InitDBService initDBService = new InitDBService();
        initDBService.initTestDb();
    }
}
