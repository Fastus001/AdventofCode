package com.karczmarzyk.advent2016.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class PinPad2Test {
    private PinPad2 pinPad2;

    @Test
    public void testClassPinPad2()
    {
        pinPad2= new PinPad2();
        pinPad2.show();
    }

    @Test
    public void testCasesFromTheTask()
    {
        pinPad2= new PinPad2();
        assertEquals( "5", pinPad2.getString( "ULL" ));
        assertEquals( "D", pinPad2.getString( "RRDDD" ));
        assertEquals( "B", pinPad2.getString( "LURDL" ));
        assertEquals( "3", pinPad2.getString( "UUUUD" ));
    }


}
