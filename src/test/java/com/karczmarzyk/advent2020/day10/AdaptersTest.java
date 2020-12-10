package com.karczmarzyk.advent2020.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdaptersTest {
    Adapters adapters;

    @BeforeEach
    void setUp() {
        Adapters.getInput("src/main/resources/2020/day10/test2.txt");
        adapters = new Adapters(49);
    }

    @Test
    void testSampleTestCase() {
        adapters.generateLists( 0 );

        assertEquals(19208,adapters.getCounter());
    }


}