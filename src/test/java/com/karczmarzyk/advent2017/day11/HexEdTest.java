package com.karczmarzyk.advent2017.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class HexEdTest {

    @Test
    void getSteps() {
        HexEd test = new HexEd("se,sw,se,sw,sw");

        int steps = test.getSteps();

        assertEquals(3, steps);
    }

    @Test
    void testFirstPart() throws IOException {
        String inputLine = Files.readString(Path.of("src/main/resources/2017/day11/input.txt"));
//        String inputLine = Files.readString(Path.of("src/main/resources/2017/day11/input2.txt"));

        HexEd firstPart = new HexEd(inputLine);

        int result = firstPart.getSteps();

        assertEquals(3, result);
    }
}
