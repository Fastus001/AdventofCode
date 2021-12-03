package com.karczmarzyk.advent2021.day3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class BinaryDiagnosticTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void computeTestCase() throws IOException {
        List<String> testInput = Files.readAllLines(Path.of("src/main/resources/2021/day3/test3.txt"));
        BinaryDiagnostic bd = new BinaryDiagnostic();
        bd.setInput(testInput);

        int gammaRate = bd.computePowerConsumtion();

        Assertions.assertThat(gammaRate).isEqualTo(198);
    }

    @Test
    void computePartOne() throws IOException {
        List<String> testInput = Files.readAllLines(Path.of("src/main/resources/2021/day3/input.txt"));
        BinaryDiagnostic bd = new BinaryDiagnostic();
        bd.setInput(testInput);

        int gammaRate = bd.computePowerConsumtion();

        Assertions.assertThat(gammaRate).isEqualTo(2498354);
    }
}