package com.karczmarzyk.advent2016.day13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CubeTest {

    private static final char EMPTY = '.';

    Cube cube;

    @BeforeEach
    void setUp() {
        cube = new Cube( EMPTY ,0,0);
    }

    @Test
    void isEmpty() {
        assertTrue( cube.isEmpty() );
    }

    @Test
    void hasMove() {
        assertFalse( cube.hasMove() );
    }
}