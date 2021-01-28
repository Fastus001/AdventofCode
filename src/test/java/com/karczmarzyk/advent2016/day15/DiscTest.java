package com.karczmarzyk.advent2016.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscTest {
    Disc disc1;
    Disc disc2;
    private static final int TIME_0 = 0;
    private static final int TIME_5 = 5;

    @BeforeEach
    void setUp() {
        disc1 = new Disc( 5,4 );
        disc2 = new Disc( 2,1 );
    }

    @Test
    void getPositionAtTime() {
        assertEquals( 0,disc1.getPositionAtTime( TIME_0 ) );
        assertEquals( 0,disc1.getPositionAtTime( TIME_5 ) );
        assertEquals( 1,disc2.getPositionAtTime( TIME_0+1 ) );
        assertEquals( 0,disc2.getPositionAtTime( TIME_5+1 ) );
    }
}