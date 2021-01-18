package com.karczmarzyk.advent2020.day25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RfidTest {
    Rfid rfid;

    @BeforeEach
    void setUp() {
        rfid = new Rfid();
    }

    @Test
    void testNumber() {
        assertEquals( 8,rfid.testNumber( 5764801 ));

    }

    @Test
    void decrypt() {
        assertAll( ()-> assertEquals( 14897079, rfid.decrypt( 5764801, 17807724)),
                   ()->assertEquals( 8329514, rfid.decrypt( 8821721, 13135480)));
    }

    @Test
    void encrypt() {
        assertEquals( 14897079,rfid.encrypt( 17807724,8 ));
    }
}