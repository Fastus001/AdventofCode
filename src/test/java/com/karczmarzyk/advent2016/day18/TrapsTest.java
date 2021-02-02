package com.karczmarzyk.advent2016.day18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrapsTest {
    Traps traps;


    @BeforeEach
    void setUp() {
        traps = new Traps();
    }

    @Test
    void checkTiles() {
        char check = traps.checkTiles( "..." );
        char check2 = traps.checkTiles( ".^^" );

        assertEquals( '.',check );
        assertEquals( '^',check2 );
    }

    @Test
    void getNewRow() {
        String newRow = traps.getNewRow( ".^^.^.^^^^" );

        assertEquals( "^^^...^..^",newRow );
    }
}