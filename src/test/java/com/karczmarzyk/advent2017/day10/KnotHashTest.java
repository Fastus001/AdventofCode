package com.karczmarzyk.advent2017.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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

    @Test
    void partTwoTestInputs() {
        KnotHash knotHash = new KnotHash(256);

        final int[] ints = Util.parseInput("1,2,3");

        for (int i = 0; i < 64; i++) {
            knotHash.start(ints);
        }

        String hash = Util.densHash(knotHash.getNumbers());

        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", hash);
    }

    @Test
    void partTwoTest() {
        KnotHash knotHash = new KnotHash(256);

        String hash = knotHash.generate("225,171,131,2,35,5,0,13,1,246,54,97,255,98,254,110");

        assertEquals("e1a65bfb5a5ce396025fab5528c25a87", hash);
    }

    @Test
    void testDay14testCases() {
        KnotHash knotHash = new KnotHash(256);

        final int[] ints = Util.parseInput("flqrgnkx-0");

        for (int i = 0; i < 64; i++) {
            knotHash.start(ints);
        }

        String hash = Util.densHash(knotHash.getNumbers());
        String binary = new BigInteger(hash, 16).toString();
        System.out.println("binary = " + binary);

        assertEquals("e1a65bfb5a5ce396025fab5528c25a87", hash);
    }
}
