package com.karczmarzyk.advent2017.day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DigitalPlumberTest {

    DigitalPlumber dp;
    List<String> input;

    @BeforeEach
    void setUp() {
        dp = new DigitalPlumber(List.of(
                "0 <-> 2", "1 <-> 1", "2 <-> 0, 3, 4","3 <-> 2, 4", "4 <-> 2, 3, 6",
                "5 <-> 6", "6 <-> 4, 5"));

    }

    @Test
    void testConstructor() {

        assertEquals(0, dp.getRecords().get(0).getNumber());
        assertEquals(7, dp.getRecords().size());
    }

    @Test
    void testExecute() {
        dp.markGroup(0);

        assertEquals(6, dp.getConnectedProgramsNo());
    }

    @Test
    void testTestCasePartTwo() {
        int groupCounter = dp.getGroupCounter();

        assertEquals(2, groupCounter);
    }

    @Test
    void testPartOneSolution() throws IOException {
        input = Files.readAllLines(Path.of("src/main/resources/2017/day12/input.txt"));
        DigitalPlumber digitalPlumber = new DigitalPlumber(input);

        digitalPlumber.markGroup(0);

        assertEquals(145, digitalPlumber.getConnectedProgramsNo());
    }

    @Test
    void testPartTwoSolution() throws IOException {
        input = Files.readAllLines(Path.of("src/main/resources/2017/day12/input.txt"));
        DigitalPlumber digitalPlumber = new DigitalPlumber(input);

        int groupCounter = digitalPlumber.getGroupCounter();

        assertEquals(207, groupCounter);
    }

}
