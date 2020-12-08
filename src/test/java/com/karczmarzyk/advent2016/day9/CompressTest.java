package com.karczmarzyk.advent2016.day9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressTest {
    Compress compress;

    @BeforeEach
    void setUp() {
        compress = new Compress();
    }

    @Test
    void testFirstTestCase() {
        compress.decrypt( "X(8x2)(3x3)ABCY" );
    }

    @Test
    void getSize() {
        compress.decrypt( "(27x12)(20x12)(13x14)(7x10)(1x12)A" );
        assertEquals( 241920,compress.getSize() );
    }
}