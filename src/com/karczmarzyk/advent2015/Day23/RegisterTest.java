package com.karczmarzyk.advent2015.Day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

        assertAll( ()->assertEquals( 1,register.getRegisterNumber() ),
                   ()->assertEquals( 1,inc_a ));
    }

    @Test
    public void testHlfInstruction()
    {
        for (int i = 0; i < 10; i++) {
            register.executeInstruction( "inc a", 1 );
        }
        register.executeInstruction( "hlf a", 1 );
        assertEquals( 5, register.getRegisterNumber());
    }

    @Test
    public void testTripleInstruction()
    {
        register.executeInstruction( "inc a", 1 );
        register.executeInstruction( "tpl a",1 );

        assertEquals( 3, register.getRegisterNumber());
    }

    @Test
    public void testJio1()
    {
        register.executeInstruction( "inc a", 1 );
        assertEquals( 8, register.executeInstruction( "jio a, +7",1 ));
        register.executeInstruction( "inc a", 1 );
        assertEquals( 0, register.executeInstruction( "jio a, +7",0 ));
    }

    @Test
    @DisplayName( "Should jump if a is even" )
    public void testJie()
    {
        register.executeInstruction( "inc a", 1 );
        assertEquals( 1, register.executeInstruction( "jie a, +10",1 ));
        register.executeInstruction( "inc a", 1 );
        assertEquals( 10, register.executeInstruction( "jie a, +10",0 ));
    }







}






















