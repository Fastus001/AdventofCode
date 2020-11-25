package com.karczmarzyk.advent2015.Day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    Register register;

    @BeforeEach
    public void setup()
    {
        register = new Register();
    }

    @Test
    public void testIncreaseInstruction()
    {
        int inc_a = register.executeInstruction( "inc a", 1 );

        assertAll( ()->assertEquals( 1,register.getA() ),
                   ()->assertEquals( 1,inc_a ));
    }

    @Test
    public void testHlfInstruction()
    {
        for (int i = 0; i < 10; i++) {
            register.executeInstruction( "inc a", 1 );
        }
        register.executeInstruction( "hlf a", 1 );

        assertEquals( 5, register.getA());
    }

}