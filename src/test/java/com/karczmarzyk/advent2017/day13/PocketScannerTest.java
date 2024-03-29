package com.karczmarzyk.advent2017.day13;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PocketScannerTest {

    @Test
    void computeSeverity() {
        PocketScanner ps = new PocketScanner(List.of("0: 3", "1: 2", "4: 4", "6: 4"));

        int severity = ps.computeSeverity();

        assertEquals(24, severity);
    }

    @Test
    void computeSeverityPartOne() throws IOException {
        PocketScanner ps = new PocketScanner(
                Files.readAllLines(Path.of("src/main/resources/2017/day13/day13.txt"))
        );

        int severity = ps.computeSeverity();

        assertEquals(1844, severity);
    }

    @Test
    void computeCleanPassTestCases() {
        PocketScanner ps = new PocketScanner(List.of("0: 3", "1: 2", "4: 4", "6: 4"));
        int result = -1;
        for (int x = 1; x < 20; x++) {
            ps.delay();
            if (ps.computeSafePass()) {
                result = x;
                break;
            }
        }

        assertEquals(10, result);
    }

    @Test
    void computeCleanPassPartTwo() throws IOException {
        PocketScanner ps = new PocketScanner(
                Files.readAllLines(Path.of("src/main/resources/2017/day13/day13.txt"))
        );

        int result = -1;
        for (int x = 1; x < 10000000; x++) {
            ps.delay();
            if (ps.computeSafePass()) {
                result = x;
                break;
            }
        }

        assertEquals(3897604, result);
    }
}
