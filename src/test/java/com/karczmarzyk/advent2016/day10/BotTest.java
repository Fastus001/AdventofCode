package com.karczmarzyk.advent2016.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {
    Bot bot;

    @BeforeEach
    void setUp() {
        bot = new Bot( 182,60 );
    }

    @Test
    void addValue() {
        assertAll( ()->assertFalse( bot.addValue( 10 ) ) ,
                   ()-> assertTrue( bot.addValue(25) ));
    }

    @Test
    void testMinValue() {
        bot.addValue( 1 );
        bot.addValue( 2 );

        assertEquals( 1,bot.getMinValue() );
    }

    @Test
    void testMaxValue() {
        bot.addValue( 1 );
        bot.addValue( 2 );

        assertEquals( 2,bot.getMaxValue() );
    }
}