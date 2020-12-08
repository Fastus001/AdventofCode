package com.karczmarzyk.advent2020.day8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    Program program;

    @BeforeEach
    void setUp() {
        program = new Program();
        program.getInputData( "src/main/resources/2020/day8/day8.txt" );
    }

    @Test
    void executeProgram() {
        int result = 0;
        for (int i = 0; i < program.sizeOfList(); i++) {
            if(program.executeProgram( i )){
                result = program.getAccumulator();
                break;
            }
        }
        assertEquals( 1056, result);
    }
}