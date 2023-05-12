package com.karczmarzyk.advent2017.day7;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TowerManagerTest {

    @Test
    void testConstructor() throws IOException {
        TowerManager manager = new TowerManager(Files.readAllLines(Path.of("src/main/resources/2017/day7/input.txt")));

        int size = manager.getTowers().size();

        assertEquals(1178, size);
    }

    @Test
    void testPartOne() throws IOException {
        TowerManager manager = new TowerManager(Files.readAllLines(Path.of("src/main/resources/2017/day7/input.txt")));

        manager.showWeight("orflty");

        //correct answer is 1679 - orflty
    }
}
