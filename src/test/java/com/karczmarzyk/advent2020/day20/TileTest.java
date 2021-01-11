package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TileTest {
    Tile tile;

    @BeforeEach
    void setUp() throws IOException {
        JigSaw jigSaw = new JigSaw( "src/main/resources/2020/day20/test.txt" );
        tile = jigSaw.getTiles(0);
    }

    @Test
    void flipVertically() {
        tile.flipVertically();
        assertEquals( "..###..###", tile.getRow(0,false));
        assertEquals( "###..###..", tile.getRow(0,true));

    }

    @Test
    void flipHorizontally() {
        tile.flipHorizontally();
        assertEquals( ".#..#.##..", tile.getRow(0,false));
    }

    @Test
    void getColumn() {
        assertEquals( ".#####..#.", tile.getColumn(0,false));
    }
}