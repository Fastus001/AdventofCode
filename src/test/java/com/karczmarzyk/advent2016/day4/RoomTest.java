package com.karczmarzyk.advent2016.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testFirstInput()
    {
        Room room = new Room( "aaaaa-bbb-z-y-x-123[abxyz]" );
        room.show();
        assertTrue( room.testRoom( room.mapChars() ) );
    }

    @Test
    void testSecondInput()
    {
        Room room = new Room( "a-b-c-d-e-f-g-h-987[abcde]" );
        room.show();
        assertTrue( room.testRoom( room.mapChars() ) );
    }

    @Test
    void testThirdInput()
    {
        Room room = new Room( "not-a-real-room-404[oarel]" );
        room.show();
        String test = room.mapChars();
        System.out.println( "test = " + test );
        assertTrue( room.testRoom( test ) );
    }

    @Test
    void testForthInput()
    {
        Room room = new Room( "totally-real-room-200[decoy]" );
        room.show();
        String test = room.mapChars();
        System.out.println( "test = " + test );
        assertFalse( room.testRoom( test ) );
    }

    @Test
    void shouldGiveIdWhenRoomIsReal()
    {
        Room room = new Room( "aaaaa-bbb-z-y-x-123[abxyz]" );
        Room room1 = new Room( "xlrypetn-prr-lylwjdtd-665[dzoya]" );
        assertEquals(123, room.getID());
        assertEquals(0, room1.getID());
    }

    @Test
    void testSamples()
    {
        Room room = new Room( "oknkvcta-itcfg-gii-wugt-vguvkpi-154[giktv]" );
        room.show();
        System.out.println( "room.mapChars2() = " + room.mapChars2() );
        String test = room.mapChars();
        System.out.println( "test = " + test );
        assertFalse( room.testRoom( test ) );
    }

}