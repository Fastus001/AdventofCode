package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JigSawTest {
    JigSaw jigSaw;
    JigSaw jigSawInput;

    @BeforeEach
    void setUp() throws IOException {
        jigSaw = new JigSaw( "src/main/resources/2020/day20/test.txt" );
        jigSawInput = new JigSaw( "src/main/resources/2020/day20/input.txt" );
    }

    @Test
    void getTiles() {
        jigSaw.getTiles( 0 ).showTile();
        assertEquals( "Tile 2311:", jigSaw.getTiles( 0 ).getIdNumber());
    }

    @Test
    void getTileSize() {
        assertEquals( 9,jigSaw.getTileSize() );
        assertEquals( 144,jigSawInput.getTileSize() );
    }
}