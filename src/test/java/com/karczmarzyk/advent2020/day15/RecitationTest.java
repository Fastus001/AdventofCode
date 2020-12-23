package com.karczmarzyk.advent2020.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecitationTest {
    Recitation recitation;

    @BeforeEach
    void setUp() {
        recitation = new Recitation("0,3,6");
    }

    @Test
    void getLastNumber() {
        assertAll(()->assertEquals(6,recitation.getLastNumber().getNumber()),
                ()->assertEquals(3,recitation.getLastNumber().getTurnNumberSecond()),
                ()->assertEquals(1,recitation.getLastNumber().getTimesSpoken()));
    }

    @Test
    void nextRound() {
        recitation.nextRound();
        assertAll(()->assertEquals(0,recitation.getLastNumber().getNumber()),
                ()->assertEquals(4,recitation.getLastNumber().getTurnNumberSecond()),
                ()->assertEquals(2,recitation.getLastNumber().getTimesSpoken()));
    }

    @Test
    void nextRounds(){
        recitation.nextRound();
        recitation.nextRound();
        assertAll(()->assertEquals(3,recitation.getLastNumber().getNumber()),
                ()->assertEquals(5,recitation.getLastNumber().getTurnNumberSecond()),
                ()->assertEquals(2,recitation.getLastNumber().getTimesSpoken()));
    }

    @Test
    void testCases(){
        for (int i = 0; i < 2017; i++) {
            recitation.nextRound();
        }
        assertEquals(436,recitation.getLastNumber().getNumber());
    }

    @Test
    void testSolution(){
        Recitation recitation = new Recitation("1,20,11,6,12,0");
        for (int i = 0; i < 2014; i++) {
            recitation.nextRound();
        }
        assertEquals(1085,recitation.getLastNumber().getNumber());
    }

    @Test
    void testSolutionPartTwo(){
        Recitation recitation = new Recitation("1,20,11,6,12,0");
        for (int i = 0; i < 29999994; i++) {
            recitation.nextRound();
        }
        assertEquals(10652,recitation.getLastNumber().getNumber());
    }
}