package com.karczmarzyk.advent2016.day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonorailTest {
    Monorail monorail;

    @BeforeEach
    void setUp() throws IOException {
        monorail = new Monorail();
        monorail.setInstructions(
                Files.readAllLines( Path.of( "src/main/resources/2016/day12/test.txt" ) ) );
    }

    @Test
    void start() {
        assertEquals(42,monorail.start());
    }

    @Test
    void testExecuteIncrease() {
        Instruction instruction = new Instruction( "inc d" );

        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(1,monorail.getRegisters().get( "d" ));
        assertEquals(1,returnVal);
    }

    @Test
    void testExecuteDecrease() {
        Instruction instruction = new Instruction( "dec c" );

        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(-1,monorail.getRegisters().get( "c" ));
        assertEquals(1,returnVal);
    }

    @Test
    void testExecuteJumpWhenFirstValueIsNumber(){
        Instruction instruction = new Instruction( "jnz 1 5" );

        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(5,returnVal);
    }

    @Test
    void testExecuteJumpWhenValueZero(){
        Instruction instruction = new Instruction( "jnz a 2" );

        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(1,returnVal);
    }

    @Test
    void testExecuteJumpWhenValueOtherThanZero(){
        Instruction inc_a = new Instruction( "inc a" );
        Instruction instruction = new Instruction( "jnz a -2" );

        monorail.executeInstruction( inc_a );
        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(-2,returnVal);
    }

    @Test
    void testExecuteCopyValueVersion(){
        Instruction instruction = new Instruction( "cpy 19 d" );

        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(1,returnVal);
        assertEquals(19,monorail.getRegisters().get( "d" ));
    }

    @Test
    void testExecuteCopyOneRegisterToAnother(){
        Instruction dec_a = new Instruction( "dec a" );
        Instruction instruction = new Instruction( "cpy a d" );

        monorail.executeInstruction( dec_a );
        int returnVal = monorail.executeInstruction( instruction );

        assertEquals(1,returnVal);
        assertEquals(-1,monorail.getRegisters().get( "d" ));
    }

    @Test
    void testSkippingWrongCopyInstruction(){
        Instruction cpyBad = new Instruction( "cpy 1 2" );

        int returnVal = monorail.executeInstruction( cpyBad );
        assertEquals(1,returnVal);
        assertEquals(0,monorail.getRegisters().get( "a" ));
        assertEquals(0,monorail.getRegisters().get( "b" ));
        assertEquals(0,monorail.getRegisters().get( "c" ));
        assertEquals(0,monorail.getRegisters().get( "d" ));
    }

    @Test
    void testToggleIncrease(){
        Monorail monorail23 = new Monorail();
        monorail23.setInstructions( getTestInstructions() );
        int size = monorail23.getInstructions().size();

        int result = -1;
        while (monorail23.getCurrentIndex()<size){
            result = monorail23.start();
        }

        assertEquals( 3, result );
    }

    private List<String> getTestInstructions() {
        List<String> temp = new ArrayList<>();
        temp.add( "cpy 2 a" );
        temp.add( "tgl a" );
        temp.add( "tgl a" );
        temp.add( "tgl a" );
        temp.add( "cpy 1 a" );
        temp.add( "dec a" );
        temp.add( "dec a" );
        return temp;
    }
}