package com.karczmarzyk.advent2017.day15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    private static final long FACTOR_A = 16807;
    private static final long FACTOR_B = 48271;
    private static final int PAIR_COUNT = 5_000_000;

    @Test
    void testCheck() {
        Judge judge = new Judge(
            new Generator(FACTOR_A, 65),
            new Generator(FACTOR_B, 8921)
        );

        boolean test = judge.isLowestBitsSame();
        assertFalse(test);
        test = judge.isLowestBitsSame();
        assertFalse(test);
        test = judge.isLowestBitsSame();
        assertTrue(test);
    }

    @Test
    void testJudgeFinalCountTestCase() {
        Judge judge = new Judge(
                new Generator(FACTOR_A, 65),
                new Generator(FACTOR_B, 8921)
        );
        int counter = 0;

        for (int i = 0; i < 40_000_000; i++) {
            if (judge.isLowestBitsSame()){
                counter++;
            }
        }

        assertEquals(588, counter);
    }

    @Test
    void testJudgeFinalCountPartOne() {
        Judge judge = new Judge(
                new Generator(FACTOR_A, 634),
                new Generator(FACTOR_B, 301)
        );
        int counter = 0;

        for (int i = 0; i < 40_000_000; i++) {
            if (judge.isLowestBitsSame()){
                counter++;
            }
        }

        assertEquals(573, counter);
    }

    @Test
    void testJudgeFinalCountTestCasePartTwo() {
        Generator generatorA = new Generator(FACTOR_A, 65);
        generatorA.setCriteria(4);
        Generator generatorB = new Generator(FACTOR_B, 8921);
        generatorB.setCriteria(8);

        int counter = 0;
        int matchCounter = 0;
        while (counter < PAIR_COUNT) {
            String valueA = generatorA.onNextValue();
            String valueB = generatorB.onNextValue();
            counter++;
            if(Judge.isLowestBitsSame(valueA, valueB)){
                matchCounter++;
            }
        }

        assertEquals(309, matchCounter);
    }

    @Test
    void testJudgeFinalCountPartTwo() {
        Generator generatorA = new Generator(FACTOR_A, 634);
        generatorA.setCriteria(4);
        Generator generatorB = new Generator(FACTOR_B, 301);
        generatorB.setCriteria(8);

        int counter = 0;
        int matchCounter = 0;
        while (counter < PAIR_COUNT) {
            String valueA = generatorA.onNextValue();
            String valueB = generatorB.onNextValue();
            counter++;
            if(Judge.isLowestBitsSame(valueA, valueB)){
                matchCounter++;
            }
        }

        assertEquals(294, matchCounter);
    }
}
