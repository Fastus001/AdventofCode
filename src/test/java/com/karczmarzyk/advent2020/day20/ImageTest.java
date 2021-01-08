package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

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
        int num = 1847;
        List<ImageTile> adjacentTiles = image.findAdjacentTiles( image.getImageById( 2221 ) );
//        image.getImageById( 2221 ).joinTiles( image.getImageById( adjacentTiles.get( 1 ).getNumber() ));
//        image.findAdjacentTiles( image.getImageById( 2309 ) );
//        image.findAdjacentTiles( image.getImageById( 3191 ) );
//        image.findAdjacentTiles( image.getImageById( 1669 ) );
//        image.findAdjacentTiles( image.getImageById( 2399 ) );
//        image.findAdjacentTiles( image.getImageById( 3461 ) );
//        image.findAdjacentTiles( image.getImageById( 2137 ) );
//        image.findAdjacentTiles( image.getImageById( 2113 ) );
//        image.findAdjacentTiles( image.getImageById( 1567 ) );
//        image.findAdjacentTiles( image.getImageById( 1163 ) );
//        image.findAdjacentTiles( image.getImageById( 1123 ) );
//        image.findAdjacentTiles( image.getImageById( 1847 ) );
        System.out.println( "this = " + image.getImageById( num ) );
        System.out.println( "up = " + image.getImageById( num ).getUp() );
        System.out.println( "down = " + image.getImageById( num ).getDown() );
        System.out.println( "left = " + image.getImageById( num ).getLeft() );
        System.out.println( "right = " + image.getImageById( num ).getRight() );
    }
}