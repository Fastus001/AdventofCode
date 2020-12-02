package com.karczmarzyk.advent2020.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void isPasswordValid1() {
        Password password = new Password( "1-3 a: abcde" );
        assertTrue( password.isPasswordValid() );
    }

    @Test
    void isPasswordValid2() {
        Password password = new Password( "1-3 b: cdefg" );
        assertFalse( password.isPasswordValid() );
    }
}