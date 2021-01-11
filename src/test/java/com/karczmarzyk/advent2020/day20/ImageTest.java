package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageTest {
    Image image;
    List<ImageTile> adjacentTiles;

    @BeforeEach
    void setUp() throws IOException {
        JigSaw jigSaw = new JigSaw( "src/main/resources/2020/day20/input.txt" );
        image = new Image( jigSaw.getImageTiles() );
    }



    @Test
    void getImageById() {
        List<ImageTile> adjacentTiles = image.findAdjacentTiles( image.getImageById( 2309 ) );

        System.out.println( "adjacentTiles.size() = " + adjacentTiles );
    }


    @Test
    void findAdjacentTiles() {
        int num = 3011;
        image.sortTiles();
        Pair xy = image.getImageById( num ).getXy();

        assertAll(()->assertEquals( 0,xy.getRow() ),
                  ()->assertEquals( 0,xy.getCol() ));

        System.out.println( "this = " + image.getImageById( num ) );
        System.out.println( "up = " + image.getImageById( num ).getUp() );
        System.out.println( "down = " + image.getImageById( num ).getDown() );
        System.out.println( "left = " + image.getImageById( num ).getLeft() );
        System.out.println( "right = " + image.getImageById( num ).getRight() );
        System.out.println( "Pair = " + image.getImageById( num ).getXy() );
    }
}