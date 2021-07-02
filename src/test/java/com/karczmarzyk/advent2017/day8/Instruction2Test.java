package com.karczmarzyk.advent2017.day8;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Instruction2Test {
    Instruction2 instruction;

    @Test
    void checkIf() {
        instruction = new Instruction2(List.of("a", "b", "c", "d"));

        boolean result = instruction.condition("a > 1");
        boolean result2 = instruction.condition("a == 0");

        assertFalse(result);
        assertTrue(result2);
    }

    @Test
    void executeInstruction() {
        instruction = new Instruction2(List.of("a", "b", "c", "d"));

        instruction.executeInstruction("c dec -10");

        assertEquals(10, instruction.getRegisters().get("c"));
    }

    @Test
    void testTestValues() {
        Instruction2 test = new Instruction2(List.of(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10"
        ));

        int result = test.start();

        assertEquals(1, result);
    }

    @Test
    void testPartOne() throws IOException {
        Instruction2 partOne = new Instruction2(Files.readAllLines(Path.of("src/main/resources/2017/day8/input.txt")));

        int result = partOne.start();

        assertEquals(5752, result);
    }
}
