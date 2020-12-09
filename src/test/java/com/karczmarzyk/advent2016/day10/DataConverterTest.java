package com.karczmarzyk.advent2016.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataConverterTest {
    DataConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DataConverter();
    }

    @Test
    void createBot() {
        converter.createBot( "bot 0 gives low to output 2 and high to output 0" );

    }
}