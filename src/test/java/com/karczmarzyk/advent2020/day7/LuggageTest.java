package com.karczmarzyk.advent2020.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuggageTest {

    @Test
    void testSimpleInput()
    {
        Luggage luggage = new Luggage( "wavy green bags contain 1 posh black bag, 1 faded green bag, 4 wavy red bags." );
        assertEquals( "wavy green",luggage.getLuggage() );
    }


    @Test
    void getLuggageNumber() {
        Luggage luggage = new Luggage( "vibrant plum bags contain 5 faded blue bags and 6 dotted black bags" );
        luggage.addOtherLuggage( new Luggage( "faded blue bags contain no other bags" ) );
        luggage.addOtherLuggage( new Luggage( "dotted black bags contain no other bags." ) );
        //11 other plus one for vibrant plum
        assertEquals( 12,luggage.getLuggageNumber() );
    }
}