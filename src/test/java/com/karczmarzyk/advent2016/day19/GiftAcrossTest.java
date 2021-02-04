package com.karczmarzyk.advent2016.day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiftAcrossTest {
    GiftAcross giftAcross;
    public static final int SIZE=5;

    @BeforeEach
    void setUp() {
        giftAcross = new GiftAcross( SIZE );
    }

    @Test
    void checkAcross() {
        giftAcross.checkAcrossFirstSieve();

        assertEquals( 2,giftAcross.getCurrentSeat().getNumber() );
    }

    @Test
    void partTwo() {
        int size = 3001330;
        GiftAcross partTwo = new GiftAcross( size );
        partTwo.checkAcrossFirstSieve();

        assertEquals( 1407007,partTwo.getCurrentSeat().getNumber() );
    }
}