package com.karczmarzyk.advent2020.day9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncodingErrorTest {
    EncodingError error;

    @BeforeEach
    void setUp() {
        error = new EncodingError( 5 );

    }

    @Test
    void setList() {
        error.setList( "src/main/resources/2020/day9/test.txt");
        assertEquals( 20, error.getListSize());
    }

    @Test
    void getErrorNumber() {
        error.setList( "src/main/resources/2020/day9/test.txt");
        long errorNumber = error.getErrorNumber();

        assertAll(
                ()-> assertEquals( 62,error.findRange( errorNumber )),
                ()->assertEquals( 127, errorNumber));
    }

    @Test
    void testPartOne()
    {
        EncodingError encoding = new EncodingError( 25 );
        encoding.setList( "src/main/resources/2020/day9/day9.txt" );
        assertEquals( 50047984,encoding.getErrorNumber() );
    }

    @Test
    void testPartTwo()
    {
        EncodingError encoding = new EncodingError( 25 );
        encoding.setList( "src/main/resources/2020/day9/day9.txt" );
        assertEquals( 5407707,encoding.findRange( 50047984 ));
    }
}