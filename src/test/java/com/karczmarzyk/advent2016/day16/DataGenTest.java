package com.karczmarzyk.advent2016.day16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataGenTest {
    DataGen gen;

    @BeforeEach
    void setUp() {
        gen = new DataGen( 20 );
    }

    @Test
    void generate() {
        String generateChecksum = gen.generate("10000");
        assertEquals( "10000011110010000111", generateChecksum);
    }
}