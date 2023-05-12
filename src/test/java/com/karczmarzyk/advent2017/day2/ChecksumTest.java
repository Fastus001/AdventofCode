package com.karczmarzyk.advent2017.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChecksumTest {

    Checksum checksum;

    @BeforeEach
    void setup(){
        checksum = new Checksum();
    }

    @Test
    void sum() {
        int sum = checksum.sum(List.of(
                "5 1 9 5",
                "7 5 3",
                "2 4 6 8"
        ));

        assertEquals(18, sum);
    }

    @Test
    void testSolutionPartOne() throws IOException {
        int sum = checksum.sum(Files.readAllLines(Path.of("src/main/resources/2017/day2/input.txt")));

        assertEquals(36766, sum);
    }

    @Test
    void partTwoTestInput() {
        int sum = checksum.sumPartTwo(List.of(
                "5 9 2 8",
                "9 4 7 3",
                "3 8 6 5"
        ));

        assertEquals(9, sum);
    }

    @Test
    void testSolutionPartTwo() throws IOException {
        int sum = checksum.sumPartTwo(Files.readAllLines(Path.of("src/main/resources/2017/day2/input.txt")));

        assertEquals(261, sum);
    }
}
