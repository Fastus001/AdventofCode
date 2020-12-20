package com.karczmarzyk.advent2020.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {
    PartTwo partTwo;

    @BeforeEach
    void setUp() {
        SeatsAdv seatsAdv = new SeatsAdv( 10 );
        seatsAdv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/test.txt" ) );
        partTwo = new PartTwo( seatsAdv );
    }

    @Test
    void transformGrid() {
        assertEquals( 26,partTwo.transformGrid());

    }

    @Test
    void testTaskPartTwo()
    {
        SeatsAdv seats = new SeatsAdv( 100 );
        seats.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/day11.txt" ) );
        partTwo = new PartTwo( seats );
        assertEquals( 2111,partTwo.transformGrid());
    }
}