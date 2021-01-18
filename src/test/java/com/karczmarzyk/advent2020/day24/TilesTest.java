package com.karczmarzyk.advent2020.day24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TilesTest {
    Tiles tiles;

    @BeforeEach
    void setUp() throws IOException {
        tiles = new Tiles();
    }

     @Test
    void checkAdjacentTiles() {
        for (int i = 1; i < 100; i++) {
            tiles.transform();
        }

        assertEquals( 3565, tiles.transform() );
    }
}