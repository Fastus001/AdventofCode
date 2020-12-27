package com.karczmarzyk.advent2020.day16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void isValid() {
        Range range = new Range(5,7);
        assertTrue(range.isValid(5));
        assertFalse(range.isValid(8));
    }
}