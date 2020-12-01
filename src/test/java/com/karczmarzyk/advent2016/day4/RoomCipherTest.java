package com.karczmarzyk.advent2016.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomCipherTest {

    @Test
    void decipher() {
        RoomCipher roomCipher = new RoomCipher( "qzmt-zixmtkozy-ivhz-343[abcde]" );
        assertEquals( "very encrypted name",roomCipher.decipher() );
    }
}