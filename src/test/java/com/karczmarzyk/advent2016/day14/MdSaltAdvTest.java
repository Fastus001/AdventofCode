package com.karczmarzyk.advent2016.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MdSaltAdvTest {
    MdSaltAdv mdSaltAdv;

    @BeforeEach
    void setUp() {
        mdSaltAdv = new MdSaltAdv( "abc" );
    }

    @Test
    void start() throws NoSuchAlgorithmException {
        int result = mdSaltAdv.start();

        assertEquals( 22551,result );
    }

    @Test
    void partTwo() throws NoSuchAlgorithmException {
        MdSaltAdv partTwo = new MdSaltAdv( "jlmsuwbz" );


        int result = partTwo.start();

        assertEquals( 22429,result );
    }
}