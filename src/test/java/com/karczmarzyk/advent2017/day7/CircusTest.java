package com.karczmarzyk.advent2017.day7;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircusTest {

    Circus circus;

    @Test
    void findBottomProgram() throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("src/main/resources/2017/day7/test.txt"));
        circus = new Circus(inputLines);

        String bottomProgram = circus.findBottomProgram();

        assertEquals("tknk", bottomProgram);
    }

    @Test
    void findBottomProgramPartOneTest() throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("src/main/resources/2017/day7/input.txt"));
        circus = new Circus(inputLines);

        String bottomProgram = circus.findBottomProgram();

        assertEquals("vmpywg", bottomProgram);
    }
}
