package com.karczmarzyk.advent2020.day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CrabAdvTest {
    CrabAdv adv;

    @BeforeEach
    void setUp() {
        adv = new CrabAdv( "487912365" );
    }

    @Test
    void testConstructor() {
        Cup cup = adv.getCupMap().get( 4 );

        assertAll( () -> assertEquals( 1_000_000, cup.getPrevious().getNumber() ),
                   () -> assertEquals( 8, cup.getNext().getNumber() ) );
    }


    @Test
    void pickUp() {
        for (int i = 0; i < 10_000_000; i++) {
            adv.pickUp();
        }

        assertEquals( 2029056128 ,adv.getFinalNumber());
    }
}