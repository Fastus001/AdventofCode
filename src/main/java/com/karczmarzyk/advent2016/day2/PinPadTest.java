package com.karczmarzyk.advent2016.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class PinPadTest {
    private PinPad pinPad;

    @Test
    public void testPinPadClass()
    {
        pinPad = new PinPad();
        pinPad.show();
    }

    @Test
    public void testMovingOnPad()
    {
        pinPad = new PinPad();
        assertEquals( 1, pinPad.getString( "ULL" ) );
    }

    @Test
    public void testMovingOnPad1()
    {
        pinPad = new PinPad();
        assertEquals( 1, pinPad.getString( "ULL" ) );
        assertEquals( 9, pinPad.getString( "RRDDD" ) );
        assertEquals( 8, pinPad.getString( "LURDL" ) );
        assertEquals( 5, pinPad.getString( "UUUUD" ) );
    }

}
