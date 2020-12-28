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
    void initCube()  {

        simulation.show(Simulation.SIZE/2-1);
    }

    @Test
    void checkCell() {
        simulation.findCellAndSetActive(0,9,0);
        assertEquals(1,simulation.checkCell(0,9,0));
        assertEquals(0,simulation.checkCell(0,10,0));
    }

    @Test
    void getCubes() {
        for (int i = 0; i < 6; i++) {
            simulation.setCubes(simulation.getCubes());
        }
        assertEquals(112,simulation.getNumberOfActiveCells());
    }

    @Test
    void checkNeighbors() {
        simulation.show(4);
        simulation.checkNeighbors(4,4,4,new boolean[10][10][10]);
    }

    @Test
    void testPartOne() throws IOException {
        Simulation test = new Simulation();
        List<String> input = Files.readAllLines(Path.of("src/main/resources/2020/day17/da17input.txt"));
        test.initCube(input);

        for (int i = 0; i < 6; i++) {
            test.setCubes(test.getCubes());
        }
        assertEquals(353,test.getNumberOfActiveCells());
    }
}