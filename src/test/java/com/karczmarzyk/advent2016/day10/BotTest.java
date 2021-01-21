package com.karczmarzyk.advent2016.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {
    Bot bot;

    @BeforeEach
    void setUp() {
        bot = new Bot( "bot 2", "bot 1", "bot 0" );
        bot.addValue( 1 );
        bot.addValue( 2 );
    }


    @Test
    void testBot() {

    }


    @Test
    void addValue() {
        assertFalse( bot.addValue( 5 ) );
        assertTrue( bot.addValue( 2 ) );
    }

    @Test
    void getValue() {
        assertAll( () -> assertEquals( 1, bot.getValue( true ) ),
                   () -> assertEquals( 2, bot.getValue( false ) ) );
    }
}