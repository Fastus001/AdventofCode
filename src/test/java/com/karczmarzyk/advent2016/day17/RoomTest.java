package com.karczmarzyk.advent2016.day17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {
    Room room;

    @BeforeEach
    void setUp() {
        room = new Room( );
        room.setPassMain( "hijkl" );
    }


    @Test
    void testHashCode() {
        List<String> result = room.testHashCode( "" );

        System.out.println( "result = " + result );
    }

    @Test
    void setPassMain() {
    }


    @Test
    void testMove() {
        String move = room.testMove( "DRURDRUDDLLDLUURRDULRLDUUDDDRR" );
        System.out.println( "move = " + move );
    }

    @Test
    void start() {
        Room room1 = new Room();
        room1.setPassMain( "ulqzkmiv" );


        String start = room1.start( List.of( "" ) );

        assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", start);
    }

    @Test
    void testPartOne(){
        Room room1 = new Room();
        room1.setPassMain( "rrrbmfta" );


        String start = room1.start( List.of( "" ) );

        assertEquals("RLRDRDUDDR", start);
    }
}