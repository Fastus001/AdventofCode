package com.karczmarzyk.advent2015.Day25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFillTest {

    @Test
    public void testClassArrayFill()
    {
        ArrayFill fill = new ArrayFill();
        fill.fillFirstTen();
//        fill.showTab();

        assertEquals( 8997277,fill.getResult() );
    }

}