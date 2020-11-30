package com.karczmarzyk.advent2016.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinPad2Test {
    private PinPad2 pinPad2;

    @BeforeEach
    public void setup()
    {
        pinPad2= new PinPad2();
    }

    @Test
    public void testClassPinPad2()
    {
        pinPad2.show();
    }

    @Test
    public void testCasesFromTheTask()
    {
        assertEquals( "5", pinPad2.getString( "ULL" ));
        assertEquals( "D", pinPad2.getString( "RRDDD" ));
        assertEquals( "B", pinPad2.getString( "LURDL" ));
        assertEquals( "3", pinPad2.getString( "UUUUD" ));
    }


}