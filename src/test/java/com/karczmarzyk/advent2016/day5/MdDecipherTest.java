package com.karczmarzyk.advent2016.day5;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MdDecipherTest {

    @Test
    void getPasswordChar() throws NoSuchAlgorithmException {
        MdDecipher mdDecipher = new MdDecipher( "abc" );
        assertEquals( "18f47a30",mdDecipher.getPassword() );
    }

    @Test
    void testTaskSolution() throws NoSuchAlgorithmException {
        MdDecipher mdDecipher = new MdDecipher( "ffykfhsq" );
        assertEquals( "c6697b55",mdDecipher.getPassword() );
    }

    @Test
    void testMdPartFull() throws NoSuchAlgorithmException {
        MdPartTwo mdPartTwo = new MdPartTwo( "ffykfhsq" );
        assertEquals( "8c35d1ab",mdPartTwo.generatePassword());
    }
}