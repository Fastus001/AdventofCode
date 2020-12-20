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
        adv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/testHard.txt"));
        assertEquals( 1,adv.checkRow( 1,1));
    }

    @Test
    void checkColumn() {
        adv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/testHard.txt"));
        assertEquals( 2,adv.checkColumn( 2,0));
        assertEquals( 0,adv.checkColumn( 2,2));
        assertEquals( 1,adv.checkColumn( 1,6));
    }

    @Test
    void checkDiagonal() {
        adv.show();
        assertEquals( 4,adv.checkDiagonal( 4,3));
    }

    @Test
    void checkDiagonalHard(){
        adv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/testHard.txt"));
        adv.show();
        assertEquals( 0,adv.checkDiagonal(2,2));
        assertEquals( 1,adv.checkDiagonal(1,8));
    }

    @Test
    void getNewGrid() {
        adv = new SeatsAdv( 10 );
        adv.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/testPart2.txt"));
        adv.setGrid( adv.getNewGrid());
        adv.show();
        assertEquals( 1,adv.checkDiagonal( 0,9));
        adv.show();
    }
}