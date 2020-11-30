package com.karczmarzyk.advent2016.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinPadTest {
    private PinPad pinPad;

    @BeforeEach
    public void setup()
    {
        pinPad = new PinPad();
    }

    @Test
    public void testPinPadClass()
    {
        pinPad.show();
    }

    @Test
    public void testMovingOnPad()
    {
        assertEquals( 1, pinPad.getString( "ULL" ) );
    }

    @Test
    public void testMovingOnPad1()
    {
        assertEquals( 1, pinPad.getString( "ULL" ) );
        assertEquals( 9, pinPad.getString( "RRDDD" ) );
        assertEquals( 8, pinPad.getString( "LURDL" ) );
        assertEquals( 5, pinPad.getString( "UUUUD" ) );
    }

}