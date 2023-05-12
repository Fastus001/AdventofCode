package com.karczmarzyk.advent2017.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMemoryTest {

    SpiralMemory sm;

    @BeforeEach
    void setUp() {
        sm = new SpiralMemory();
    }

    @Test
    void steps() {
        int steps = sm.steps(1024);

        assertEquals(31, steps);
    }

    @Test
    void testPartOneSolution() {
        int steps = sm.steps(265149);

        assertEquals(438, steps);
    }

    @Test
    void testPartTwo() {
        int firstValueAbove = sm.findFirstValueAbove(265149);

        assertEquals(266330, firstValueAbove);
    }
}
