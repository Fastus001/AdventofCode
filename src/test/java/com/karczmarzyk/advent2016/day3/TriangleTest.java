package com.karczmarzyk.advent2016.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void isItTriangle() {
        assertFalse( Triangle.isItTriangle( " 50   18  156" ) );
    }
}