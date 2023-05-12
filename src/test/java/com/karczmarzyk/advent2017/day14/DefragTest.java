package com.karczmarzyk.advent2017.day14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DefragTest {

    @Test
    void checkIfPassTestCase() {
        Defrag defrag = new Defrag();

        int result = defrag.getSquares("flqrgnkx");
        int regions = defrag.scanForRegions();

        assertEquals(8108, result);
        assertEquals(1242, regions);
    }

    @Test
    void testPartOneSolution() {
        Defrag defrag = new Defrag();

        int result = defrag.getSquares("wenycdww");
        int regions = defrag.scanForRegions();

        assertEquals(8226, result);
        assertEquals(1128, regions);
    }
}
