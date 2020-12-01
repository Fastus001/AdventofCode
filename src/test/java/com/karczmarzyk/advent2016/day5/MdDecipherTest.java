package com.karczmarzyk.advent2016.day5;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class MdDecipherTest {

    @Test
    void getPasswordChar() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MdDecipher mdDecipher = new MdDecipher( "abc" );
        assertEquals( "18f47a30",mdDecipher.getPassword() );
    }
}