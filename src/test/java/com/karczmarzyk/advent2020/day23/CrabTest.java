package com.karczmarzyk.advent2020.day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrabTest {
    Crab crab;

    @BeforeEach
    void setUp() {
        crab = new Crab( "389125467" );
    }

    @Test
    void getCaps() {
        System.out.println(crab.getCaps());
    }

    @Test
    void pickUp() {
        assertEquals( Arrays.asList( 7,3,8 ), crab.pickUp( 7));
    }

    @Test
    void round() {
        for (int i = 0; i < 10; i++) {
            crab.round();
        }
    }
}