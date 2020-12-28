package com.karczmarzyk.advent2020.day17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    Simulation simulation;
    List<String> strings;

    @BeforeEach
    void setUp() throws IOException {
        simulation = new Simulation();
        strings = Files.readAllLines(Path.of("src/main/resources/2020/day17/day17test.txt"));
        simulation.initCube(strings);
    }

    @Test
    void getCubes() {
        for (int i = 0; i < 6; i++) {
            simulation.setCubes(simulation.getCubes());
        }
        assertEquals(848,simulation.getNumberOfActiveCells());
    }

    @Test
    void testPartOne() throws IOException {
        Simulation test = new Simulation();
        List<String> input = Files.readAllLines(Path.of("src/main/resources/2020/day17/da17input.txt"));
        test.initCube(input);

        for (int i = 0; i < 6; i++) {
            test.setCubes(test.getCubes());
        }
        assertEquals(2472,test.getNumberOfActiveCells());
    }
}