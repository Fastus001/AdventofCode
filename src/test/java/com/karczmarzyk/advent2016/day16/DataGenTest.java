package com.karczmarzyk.advent2016.day16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataGenTest {
    DataGen gen;

    @BeforeEach
    void setUp() {
        gen = new DataGen( 20 );
    }

    @Test
    void generate() {
        String generateChecksum = gen.generateData( "10000");
        assertEquals( "10000011110010000111", generateChecksum);
    }

    @Test
    void generateChecksum() {
        String result = gen.generateChecksum( "110010110100" );

        assertEquals( "100",result );
    }

    @Test
    void testTestCase(){
        String result = gen.generateChecksum( gen.generateData( "10000" ) );

        assertEquals( "01100",result );
    }


}