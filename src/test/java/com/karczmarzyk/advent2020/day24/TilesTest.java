package com.karczmarzyk.advent2020.day24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TilesTest {
    Tiles tiles;

    @BeforeEach
    void setUp() throws IOException {
        tiles = new Tiles();
    }

    @Test
    void testConstructor(){

    }

    @Test
    void checkAdjacentTiles() {
        tiles.transform();
    }
}