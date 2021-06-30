package com.karczmarzyk.advent2017.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrampolineTest {

    Trampoline trampoline;

    @BeforeEach
    void setUp() {
        trampoline = new Trampoline();
    }

    @Test
    void start() {
        trampoline.loadData(List.of("0","3","0","1","-3"));

        int result = trampoline.start();

        assertEquals(5, result);
    }

    @Test
    void startPartOneTest() throws IOException {
        trampoline.loadData(Files.readAllLines(Path.of("src/main/resources/2017/day5/day5.txt")));

        int result = trampoline.start();

        assertEquals(336905, result);
    }
}
