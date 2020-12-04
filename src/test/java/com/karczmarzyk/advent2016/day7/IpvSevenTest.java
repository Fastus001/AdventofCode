package com.karczmarzyk.advent2016.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IpvSevenTest {

    @Test
    void isIpCorrectTestCases() {
        IpvSeven ipvSeven = new IpvSeven();
        assertTrue( ipvSeven.isIpCorrect( "abba[mnop]qrst" ) );
        assertFalse( ipvSeven.isIpCorrect( "abcd[bddb]xyyx" ) );
        assertFalse( ipvSeven.isIpCorrect( "aaaa[qwer]tyui" ) );
        assertTrue( ipvSeven.isIpCorrect( "ioxxoj[asdfgh]zxcvbn" ) );
    }


    @Test
    void testisTextCorrect() {
        IpvSeven ipvSeven = new IpvSeven();
        assertFalse( ipvSeven.isTextCorrect( "abcd[dddd]xyyx" ));
    }
}