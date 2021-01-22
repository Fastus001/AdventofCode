package com.karczmarzyk.advent2016.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratorTest {

    @Test
    void generate() {

        List<int[]> generate = Generator.generate( 3 );

        assertEquals( 3,generate.size() );
    }
}