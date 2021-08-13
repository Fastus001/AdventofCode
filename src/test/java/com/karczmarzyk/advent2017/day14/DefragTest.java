package com.karczmarzyk.advent2017.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefragTest {

    @Test
    void checkIfPassTestCase() {
        int result = new Defrag().getSquares("flqrgnkx");

        assertEquals(8108, result);
    }

    @Test
    void testPartOneSolution() {
        int result = new Defrag().getSquares("wenycdww");

        assertEquals(8226, result);
    }
}
