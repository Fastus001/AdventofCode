package com.karczmarzyk.advent2017.day6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemRollTest {

    MemRoll memRoll;

    @BeforeEach
    void setUp() {
        memRoll = new MemRoll(new int[]{0, 2, 7, 0});
    }

    @Test
    void testStringValue() {
        String arrayAsString = memRoll.toStringStamp();

        assertEquals("[0, 2, 7, 0]", arrayAsString);
    }

    @Test
    void testReallocation() {
        memRoll.reallocate();

        assertEquals("[2, 4, 1, 2]", memRoll.toStringStamp());
    }

    @Test
    void testTwoReallocation() {
        memRoll.reallocate();
        memRoll.reallocate();

        assertEquals("[3, 1, 2, 3]", memRoll.toStringStamp());
    }
}
