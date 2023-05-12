package com.karczmarzyk.advent2017.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassphrasesTest {

    Passphrases passphrases;
    List<String> allLines;

    @BeforeEach
    void setUp() throws IOException {
        passphrases = new Passphrases();
        allLines = Files.readAllLines(Path.of("src/main/resources/2017/day4/input.txt"));
    }

    @Test
    void validatePhrase() {
        boolean result = passphrases.isPhraseValid("aa bb cc dd aaa");
        boolean result2 = passphrases.isPhraseValid("cfg cfg rgahl frm emn pbfsmgy frm jemwqgn sfpm azunntj igl");

        assertTrue(result);
        assertFalse(result2);
    }

    @Test
    void partOneSolution() {
        long numberOfValidPhrases = passphrases.numberOfValidPhrases(allLines);

        assertEquals(477, numberOfValidPhrases);
    }

    @Test
    void validatePhrasePartTwo() {
        long result = passphrases.numberOfValidPhrasesPartTwo(List.of("oiii ioii iioi iiio"));

        assertEquals(0, result);
    }

    @Test
    void partTwoSolution() {
        long numberOfValidPhrases = passphrases.numberOfValidPhrasesPartTwo(allLines);

        assertEquals(167, numberOfValidPhrases);
    }
}
