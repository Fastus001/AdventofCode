package com.karczmarzyk.advent2017.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class KnotHashTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void reverseSublist() {
        KnotHash knotHash = new KnotHash(5);

        knotHash.reverseSublist(3);

        assertEquals("[2, 1, 0, 3, 4]", knotHash.getNumbers().toString());
    }

    @Test
    void reverseSublistTwoMoves() {
        KnotHash knotHash = new KnotHash(5);

        knotHash.reverseSublist(3);
        knotHash.reverseSublist(4);
        int currentPosition = knotHash.getCurrentPosition();

        assertEquals("[4, 3, 0, 1, 2]", knotHash.getNumbers().toString());
        assertEquals(3, currentPosition);
    }

    @Test
    void knotHashTestCases() {
        KnotHash knotHash = new KnotHash(5);

        int result = knotHash.start(3, 4, 1, 5);
        int currentPosition = knotHash.getCurrentPosition();
        int skipSize = knotHash.getSkipSize();

        assertEquals("[3, 4, 2, 1, 0]", knotHash.getNumbers().toString());
        assertEquals(4, currentPosition);
        assertEquals(4, skipSize);
        assertEquals(12, result);
    }

    @Test
    void partOneTest(){
        KnotHash knotHash = new KnotHash(256);

        int result = knotHash.start(225, 171, 131, 2, 35, 5, 0, 13, 1, 246, 54, 97, 255, 98, 254, 110);

        assertEquals(23874, result);
    }
}
