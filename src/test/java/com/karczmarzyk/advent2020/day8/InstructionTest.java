package com.karczmarzyk.advent2020.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    @Test
    void executeInstruction() {
        Instruction instruction = new Instruction( "acc",28 );

        instruction.executeInstruction();

        assertEquals( 28, instruction.getAccumulator() );
    }
}