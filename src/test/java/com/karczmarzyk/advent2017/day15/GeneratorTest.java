package com.karczmarzyk.advent2017.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    private static final long FACTOR_A = 16807;
    private static final long FACTOR_B = 48271;


    @Test
    void onNext() {
        Generator generatorA = new Generator(FACTOR_A, 65);
        Generator generatorB = new Generator(FACTOR_B, 8921);


        String onNextA = generatorA.onNext();
        String onNextB = generatorB.onNext();

        assertEquals("100001010101101100111", onNextA);
        assertEquals("11001101010101101001100110111", onNextB);
    }
}
