package com.karczmarzyk.advent2020.day6;

import com.karczmarzyk.advent2020.day4.InputConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomAdvancedTest {
    InputConverter converter;

    @BeforeEach
    void setup()
    {
        converter = new InputConverter();
        converter.getInput( "src/main/resources/2020/day6/testInput.txt" );
    }

    @Test
    void getInput() {
        assertEquals( 1,CustomAdvanced.getInput( "b" ));
    }

    @Test
    void testTestInput()
    {
        List<String> list = converter.getList();
        int sum = 0;
        for(String s:list){
            sum += CustomAdvanced.getInput( s );
        }

        assertEquals( 6,sum);
    }
}