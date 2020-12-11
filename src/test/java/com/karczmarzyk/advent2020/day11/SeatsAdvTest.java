package com.karczmarzyk.advent2020.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatsAdvTest {
    SeatsAdv adv;

    @BeforeEach
    void setUp() {
        adv = new SeatsAdv( 10 );
        adv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/test1.txt"));
    }

    @Test
    void getNumberOfOccupiedSeats() {
        assertEquals( 8,adv.getNumberOfOccupiedSeats( 4,3));
    }

    @Test
    void checkRow() {
        assertEquals( 2,adv.checkRow( 4));
    }

    @Test
    void checkColumn() {
        assertEquals( 2,adv.checkColumn( 3));
    }

    @Test
    void checkDiagonal() {
        assertEquals( 4,adv.checkDiagonal( 4,3));
    }

    @Test
    void getNewGrid() {
        adv = new SeatsAdv( 10 );
        adv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/testPart2.txt"));
        adv.setGrid( adv.getNewGrid());
        assertEquals( 3,adv.checkDiagonal( 0,8));
        adv.show();
    }
}