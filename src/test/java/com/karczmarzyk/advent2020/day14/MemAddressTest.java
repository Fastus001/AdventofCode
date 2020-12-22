package com.karczmarzyk.advent2020.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemAddressTest {
    MemAddress address;

    @BeforeEach
    void setUp() {
        address = new MemAddress();
    }

    @Test
    void getSumOfMem() {
        address.setDecoderMask("000000000000000000000000000000X1001X");
        address.addToMemory(42,100);
        address.setDecoderMask("00000000000000000000000000000000X0XX");
        address.addToMemory(26,1);
       assertEquals(208,address.getSumOfMem());
    }
}