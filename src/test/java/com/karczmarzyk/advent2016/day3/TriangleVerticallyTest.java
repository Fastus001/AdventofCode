package com.karczmarzyk.advent2016.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleVerticallyTest {

    @Test
    void addLine() {
        assertEquals( 3,TriangleVertically.addLine( "566  477  376 575  488  365 50   18  156" ));
    }
}