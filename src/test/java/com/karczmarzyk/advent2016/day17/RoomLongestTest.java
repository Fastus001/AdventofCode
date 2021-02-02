package com.karczmarzyk.advent2016.day17;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomLongestTest {

    @Test
    void start() {
        RoomLongest roomLongest = new RoomLongest();
        roomLongest.setPassMain( "ihgpwlah" );

        String result = roomLongest.start( List.of( "" ) );

        assertEquals( "370",result );
    }

    @Test
    void testPartTwo() {
        RoomLongest roomLongest = new RoomLongest();
        roomLongest.setPassMain( "rrrbmfta" );

        String result = roomLongest.start( List.of( "" ) );

        assertEquals( "420",result );
    }
}