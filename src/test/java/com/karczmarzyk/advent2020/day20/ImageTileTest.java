package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageTileTest {
    JigSaw jigSaw;
    ImageTile imageTile;

    @BeforeEach
    void setUp() throws IOException {
        jigSaw = new JigSaw( "src/main/resources/2020/day20/test.txt" );
        imageTile = new ImageTile( jigSaw.getTiles(0) );
    }

    @Test
    void checkTile() {

        assertEquals( 2,imageTile.checkTile( jigSaw.getTiles( 1 ) ));
    }

}