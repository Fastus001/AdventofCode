package com.karczmarzyk.advent2020.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputConverterTest {
    InputConverter converter;

    @BeforeEach
    void setUp() {
        converter = new InputConverter();
    }

    @Test
    void getInput() {
        converter.getInput( "src/main/resources/2020/day4/testCases.txt" );
        converter.showList();
        assertEquals( 4,converter.getListSize() );
    }
}