package com.karczmarzyk.advent2016.day9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecompressTest {
    Decompress decompress;

    @BeforeEach
    void setDecompress(){
        decompress = new Decompress();
    }

    @Test
    void decryptSimpleTest() {
         decompress.decrypt( "A(1x5)BC");

         assertEquals( "ABBBBBC",decompress.getSbString() );
    }

    @Test
    void decryptSimpleTest2() {
        decompress.decrypt( "(3x3)XYZ");

        assertEquals( "XYZXYZXYZ",decompress.getSbString() );
    }

    @Test
    void decryptSimpleTest3() {
        decompress.decrypt( "A(2x2)BCD(2x2)EFG");

        assertEquals( "ABCBCDEFEFG",decompress.getSbString() );
    }

    @Test
    void decryptSimpleTest4() {
        decompress.decrypt( "(6x1)(1x3)A");

        assertEquals( "(1x3)A",decompress.getSbString() );
    }

    @Test
    void decryptSimpleTest5() {
        decompress.decrypt( "X(8x2)(3x3)ABCY");

        assertEquals( "X(3x3)ABC(3x3)ABC",decompress.getSbString() );
    }


}