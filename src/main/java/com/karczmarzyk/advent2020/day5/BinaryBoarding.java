package com.karczmarzyk.advent2020.day5;

import java.util.Arrays;
import java.util.BitSet;

public class BinaryBoarding {
    private BitSet seat;

    public BinaryBoarding() {
        this.seat = new BitSet(10);
    }

    public String setBits(String in)
    {
        seat.clear();

        char[] tab = in.toCharArray();
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] == 'B' || tab[i] == 'R'){
                seat.set( 9-i );
            }
        }
        return Arrays.toString( seat.toLongArray())
                .replace( "[","" )
                .replace( "]","" );
    }



}
