package com.karczmarzyk.advent2016.day21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScramblerTest {
    Scrambler scrambler;

    @BeforeEach
    void setUp() {
        scrambler = new Scrambler( "abcde" );
    }

    @Test
    void swapPosition() {
        scrambler.swapPosition( 0, 4 );

        assertEquals( "ebcda", scrambler.toString() );
    }

    @Test
    void swapLetter() {
        scrambler.swapPosition( 0, 4 );
        scrambler.swapLetter( 'd','b' );

        assertEquals( "edcba", scrambler.toString() );
    }

    @Test
    void rotateRight() {
        Scrambler sc = new Scrambler( "abcd" );
        sc.rotate( 1 , true);

        assertEquals( "dabc", sc.toString() );
    }

    @Test
    void rotateLeft() {
        Scrambler sc = new Scrambler( "abcde" );
        sc.rotate( 1 ,false);

        assertEquals( "bcdea", sc.toString() );
    }

    @Test
    void reversePositions() {
        Scrambler sc = new Scrambler( "abcdegfh" );
        sc.reversePositions( 1 ,6);

        assertEquals( "afgedcbh", sc.toString() );
    }

    @Test
    void movePosition() {
        Scrambler sc = new Scrambler( "bcdea" );
        sc.movePosition( 1 ,4);

        assertEquals( "bdeac", sc.toString() );
    }

    @Test
    void movePositionTwo() {
        Scrambler sc = new Scrambler( "bdeac" );
        sc.movePosition( 3 ,0);

        assertEquals( "abdec", sc.toString() );
    }

    @Test
    void rotateBasedOnPosition() {
        Scrambler sc = new Scrambler( "abdec" );
        sc.rotateBasedOnPosition('b');

        assertEquals( "ecabd", sc.toString() );
    }

    @Test
    void rotateBasedOnPositionTwo() {
        Scrambler sc = new Scrambler( "ecabd" );
        sc.rotateBasedOnPosition('d');

        assertEquals( "decab", sc.toString() );
    }
}

