package com.karczmarzyk.advent2016.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IpRangeTest {
    IpRange range;

    @BeforeEach
    void setUp() {
        range = new IpRange( 0,1847080 );
    }

    @Test
    void isInRange() {
        IpRange test = new IpRange( 1847081,14276375);

        assertTrue( range.isInRange( test ));
    }

    @Test
    void joinRangesOneDifference() {
        IpRange test = new IpRange( 1847081,14276375);

        IpRange result = range.joinRanges( test );

        assertEquals( new IpRange( 0,14276375 ),result );
    }

}