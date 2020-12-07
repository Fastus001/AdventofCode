package com.karczmarzyk.advent2020.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomTest {

    @Test
    void countCustomQuestions() {
        assertEquals( 6,Custom.countCustomQuestions( "abcxabcyabcz" ) );
    }
}