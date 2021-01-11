package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JigSawTest {
    JigSaw jigSaw;

    @BeforeEach
    void setUp() throws IOException {
        jigSaw = new JigSaw( "src/main/resources/2020/day20/test.txt" );
    }

    @Test
    void getTiles() {
        assertEquals( 2311, jigSaw.getTiles( 0 ).getIdNumber());
    }

    @Test
    void getTileSize() {
        assertEquals( 9,jigSaw.getTileSize() );
    }
}