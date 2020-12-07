package com.karczmarzyk.advent2020.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryBoardingTest {
    BinaryBoarding boarding;

    @BeforeEach
    void setUp() {
        boarding = new BinaryBoarding();
    }

    @Test
    void setBits() {
        assertEquals( "357",boarding.setBits( "FBFBBFFRLR" ));
        assertEquals( "567",boarding.setBits( "BFFFBBFRRR" ));
        assertEquals( "119",boarding.setBits( "FFFBBBFRRR" ));
        assertEquals( "820",boarding.setBits( "BBFFBBFRLL" ));
    }
}