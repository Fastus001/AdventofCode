package com.karczmarzyk.advent2020.day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrabAdvTest {
    CrabAdv adv;

    @BeforeEach
    void setUp() {
        adv = new CrabAdv( "487912365" );
    }

    @Test
    void show() {
        adv.show( 0 );
    }

    @Test
    void round() {
        for (int i = 0; i < 10_000_000; i++) {
            adv.round( i );
            if(i%1000==0){
                System.out.println(i);
                adv.show( i );
                System.out.println( adv.getTwoAfterOne() );
            }
        }
        System.out.println( "adv = " + adv.getNumber() );
    }
}