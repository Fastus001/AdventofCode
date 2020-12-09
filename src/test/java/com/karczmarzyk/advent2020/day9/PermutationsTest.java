package com.karczmarzyk.advent2020.day9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsTest {
    Permutations permutations;

    @BeforeEach
    void setUp() {
        permutations = new Permutations( 2 );
    }

    @Test
    void generate() {
        permutations.setNUMBERS( Arrays.asList( 1l, 2l, 3l, 4l, 5l ));


        assertEquals( 10,permutations.generate().size() );
    }
}