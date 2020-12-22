package com.karczmarzyk.advent2020.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitmaskTest {
    Bitmask bitmask;

    @BeforeEach
    void setUp() {
        bitmask = new Bitmask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
    }

    @Test
    void setMask() {
    }

    @Test
    void showNumberAsBits() {
        assertEquals(64,bitmask.convertNumberToBitString(0));
    }
}