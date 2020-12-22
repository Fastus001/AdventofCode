package com.karczmarzyk.advent2020.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DockingDataTest {
    DockingData data;

    @BeforeEach
    void setUp() {
        data = new DockingData();
        data.setBitmaskMask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        data.addToMemory(8,11);
        data.addToMemory(7,101);
        data.addToMemory(8,0);
    }

    @Test
    void getSumOfMem() {
        assertEquals(165,data.getSumOfMem());
    }
}