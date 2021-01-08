package com.karczmarzyk.advent2020.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageTileTest {
    JigSaw jigSaw;
    ImageTile tileMain;
    ImageTile adjacent;
    ImageTile adjacent2381;

    //132 - 2309
    //57 - 1997
    @BeforeEach
    void setUp() throws IOException {
        jigSaw = new JigSaw( "src/main/resources/2020/day20/input.txt" );
//        for (int i = 0; i < jigSaw.getTileSize(); i++) {
//            if(jigSaw.getTiles(i).getIdNumber()==1997){
//                System.out.println( "i = " + i );
//            }
//        }
        tileMain = new ImageTile( jigSaw.getTiles( 132) );
        adjacent = new ImageTile( jigSaw.getTiles( 57) ); //2309
        adjacent2381 = new ImageTile( jigSaw.getTiles( 57) );
    }
    @Test
    void findAndJoinAdjacentTiles2381Left() {
        tileMain.getTile().rotateLeft();
        tileMain.setLock( true );
        adjacent2381.getTile().showTile();
        tileMain.getTile().showTile();
//        tileMain.getTile().rotateLeft();
//        adjacent2381.getTile().showTile();

        tileMain.joinTiles( adjacent2381 );
        adjacent2381.getTile().showTile();


        assertAll( ()->assertNotNull( adjacent2381.getRight() ),
                   ()->assertNotNull( tileMain.getLeft() ),
                   ()->assertTrue( adjacent2381.isLock() ) );
    }

    @Test
    void findAndJoinAdjacentTilesLeft() {
//        tile2221.getTile().showTile();
        tileMain.getTile().rotateLeft();
//        tile2221.getTile().showTile();

        tileMain.joinTiles( adjacent );
//        tile2309.getTile().showTile();


        assertAll( ()->assertNotNull( adjacent.getRight() ),
                   ()->assertNotNull( tileMain.getLeft() ),
                   ()->assertTrue( adjacent.isLock() ) );
    }
    @DisplayName( "Should join adjacent tile to the right side of tile" )
    @Test
    void findAndJoinAdjacentTilesRight() {
        tileMain.getTile().showTile();
        tileMain.getTile().rotateLeft();
        tileMain.getTile().rotateLeft();
        tileMain.getTile().rotateLeft();
        tileMain.getTile().showTile();

        tileMain.joinTiles( adjacent);
        adjacent.getTile().showTile();


        assertAll( ()->assertNotNull( adjacent.getLeft() ),
                   ()->assertNotNull( tileMain.getRight() ),
                   ()->assertTrue( adjacent.isLock() ) );
    }
    @DisplayName( "Should join adjacent tile to the left side of tile" )
    @Test
    void findAndJoinAdjacentTilesUp() {

        tileMain.joinTiles( adjacent);
        adjacent.getTile().showTile();
        tileMain.getTile().showTile();


        assertAll( ()->assertNotNull( adjacent.getDown() ),
                   ()->assertNotNull( tileMain.getUp() ),
                   ()->assertTrue( adjacent.isLock() ) );
    }

    @Test
    void findAndJoinAdjacentTilesDown() {
        tileMain.getTile().rotateLeft();
        tileMain.getTile().rotateLeft();

        tileMain.joinTiles( adjacent);

        adjacent.getTile().showTile();
        tileMain.getTile().showTile();

        assertAll( ()->assertNotNull( adjacent.getUp() ),
                   ()->assertNotNull( tileMain.getDown() ),
                   ()->assertTrue( adjacent.isLock() ) );

    }

    @Test
    void checkTile() {
        
    }

    @Test
    void testCheckTileOnInput() throws IOException {
    }

    @Test
    void joinTiles() {

    }
}