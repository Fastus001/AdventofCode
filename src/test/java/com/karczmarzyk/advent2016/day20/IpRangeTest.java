package com.karczmarzyk.advent2016.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IpRangeTest {
    IpRange range;

    @BeforeEach
    void setUp() {
        range = new IpRange( 150,2500 );
    }

    @Test
    void isInRange() {
        IpRange test = new IpRange( 2500,12000 );

        assertTrue( range.isInRange( test ));
    }

    @Test
    void isInRangeShouldFail() {
        IpRange test = new IpRange( 0,149 );

        assertFalse( range.isInRange( test ));
    }

    @Test
    void joinRangesNewCoverOld() {
        IpRange ipRange = new IpRange( 130 , 2501);

        IpRange result = range.joinRanges( ipRange );

        assertEquals( new IpRange( 130,2501 ),result );
    }

    @Test
    void joinRangesOldCoverNew() {
        IpRange ipRange = new IpRange( 150 , 2499);

        IpRange result = range.joinRanges( ipRange );

        assertEquals( new IpRange( 150,2500 ),result );
    }

    @Test
    void joinRangesNewHaveHigherMax() {
        IpRange ipRange = new IpRange( 1200 , 20499);

        IpRange result = range.joinRanges( ipRange );

        assertEquals( new IpRange( 150,20499 ),result );
    }

    @Test
    void joinRangesNewHaveLoverMin() {
        IpRange ipRange = new IpRange( 0 , 450);

        IpRange result = range.joinRanges( ipRange );

        assertEquals( new IpRange( 0,2500 ),result );
    }
}