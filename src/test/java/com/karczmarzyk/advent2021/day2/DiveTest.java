package com.karczmarzyk.advent2021.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiveTest {



    @BeforeEach
    void setUp() {
    }

    @Test
    void computeDistance() throws IOException {
        List<String> input = Files.readAllLines(Path.of("src/main/resources/2021/day2/input"));

        int distance = Dive.computeDistance(input, Dive.move());

        //correct when use move()
        assertEquals(1383564, distance);
    }

    @Test
    void computeDistancePartTwo() throws IOException {
        List<String> input = Files.readAllLines(Path.of("src/main/resources/2021/day2/input"));

        int distance = Dive.computeDistance(input, Dive.move2());

        assertEquals(1488311643, distance);
    }
}