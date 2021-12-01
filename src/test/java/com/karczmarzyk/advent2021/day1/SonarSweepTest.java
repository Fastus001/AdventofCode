package com.karczmarzyk.advent2021.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SonarSweepTest {

    @Test
    void countDepthIncrease() {
        int [] input = {199,200,208,210,200,207,240,269,260,263};

        int result = SonarSweep.countDepthIncrease(input);

        assertEquals(7, result);
    }

    @Test
    void testPartOne() throws IOException {
        int[] input = Files.readAllLines(Path.of("src/main/resources/2021.day1/input.txt")).stream().mapToInt(Integer::parseInt)
                .toArray();

        int result = SonarSweep.countDepthIncrease(input);

        assertEquals(1266, result);
    }

    @Test
    void partTwoTestSample() {
        int [] input = {199,200,208,210,200,207,240,269,260,263};
        int[] afterConversion = SonarSweep.convertToThreeMeasurement(input);

        int result = SonarSweep.countDepthIncrease(afterConversion);

        assertEquals(5, result);
    }

    @Test
    void testPartTwo() throws IOException {
        int[] input = Files.readAllLines(Path.of("src/main/resources/2021.day1/input.txt")).stream().mapToInt(Integer::parseInt)
                .toArray();
        int[] afterConversion = SonarSweep.convertToThreeMeasurement(input);

        int result = SonarSweep.countDepthIncrease(afterConversion);

        assertEquals(1217, result);
    }
}