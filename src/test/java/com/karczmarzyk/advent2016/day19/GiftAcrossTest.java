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
    void testConstructor(){

    }

    @Test
    void checkAcross() {
        for (int i = 0; i < SIZE-1; i++) {
            giftAcross.checkAcross();
        }

        assertEquals( 2,giftAcross.getCurrentSeat().getNumber() );
    }

    @Test
    void partTwo() {
        int size = 3001330;
//        int size = 1000000;
        GiftAcross partTwo = new GiftAcross( size );
        partTwo.checkAcrossFirstSieve();
        System.out.println( "partTwo.getSeatMap().size() = " + partTwo.getSeatMap().size() );

        int i = 0;
        while (partTwo.getSeatMap().size()>1){
            partTwo.checkAcross();
            if(i%1000==0){
                System.out.println(i + "  "+ partTwo.getCurrentSeat().getNumber());
                System.out.println( "partTwo.getSeatMap().size() = " + partTwo.getSeatMap().size() );
            }
            i++;
        }

        System.out.println( "partTwo.getSeatMap().size() = " + partTwo.getSeatMap().size() );
        assertEquals( 1407007,partTwo.getCurrentSeat().getNumber() );
    }
}