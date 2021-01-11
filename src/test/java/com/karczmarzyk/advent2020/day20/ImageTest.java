package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageTest {
    Image image;

    @BeforeEach
    void setUp() throws IOException {
        JigSaw jigSaw = new JigSaw( "src/main/resources/2020/day20/input.txt" );
        image = new Image( jigSaw.getImageTiles() );
    }

    @Test
    void findAdjacentTiles() {
        int num = 3011;
        image.sortTiles();
        Pair xy = image.getImageById( num ).getXy();

        assertAll(()->assertEquals( 0,xy.getRow() ),
                  ()->assertEquals( 0,xy.getCol() ));

        image.getImageById( num ).getTile().showTile();
    }

    @Test
    void getOneImageLineWithoutBorderAndGaps() {
        image.sortTiles();
        List<String> list = new ArrayList<>();
        list.add( "tile:00001" );
        for (int i = 0; i < 12; i++) {
            list.addAll( image.getOneImageLineWithoutBorderAndGaps(i));
        }

        assertEquals( "..#.#...",list.get( 1 ).substring( 0,8 ) );
    }
}