package com.karczmarzyk.advent2020.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatingSystemTest {
    SeatingSystem system;

    @BeforeEach
    void setUp() {
        Seats seats = new Seats( 10 );
        seats.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/test.txt" ) );
        system = new SeatingSystem( seats );
    }

    @Test
    void transformGrid() {
        assertEquals( 37,system.transformGrid());
    }

    @Test
    void testTaskPartOne()
    {
        Seats seats = new Seats( 100 );
        seats.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/day11.txt" ) );
        system = new SeatingSystem( seats );
        assertEquals( 2346,system.transformGrid());
    }

    @Test
    void testPartTwoLastTestCase()
    {
        SeatsAdv seats = new SeatsAdv( 10 );
        seats.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/test.txt" ) );
        system = new SeatingSystem( seats );
        system.transformGrid();
    }
}