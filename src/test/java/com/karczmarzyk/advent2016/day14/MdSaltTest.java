package com.karczmarzyk.advent2016.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MdSaltTest {
    MdSalt salt;

    @BeforeEach
    void setUp()  {
        salt = new MdSalt( "abc" );
    }

    @Test
    void generateHash() {
        assertEquals( "0034e0923cc38887a57bd7b1d4f953df",salt.generateHash("abc18") );
    }

    @Test
    void checkString() {
        assertTrue( salt.checkHash( ".cc38887a5.88" ) );
    }

    @Test
    void start() throws NoSuchAlgorithmException {
        assertEquals( 22728,salt.start());
    }

    @Test
    void nextThousand() {
        boolean nextThousand = salt.nextThousand( "abc", "eeeee", 39 );

        assertTrue( nextThousand );
    }

    @Test
    void checkHash() {
        assertTrue( salt.checkHash( "34e0923cc38887a57bd7b1d4f953df" ) );
    }

    @Test
    void getIndexOfChars() {
        assertEquals( 10,salt.getIndexOfChars( "34e0923cc38887a57bd7b1d4f953df" ) );
    }

    @Test
    void partOne() throws NoSuchAlgorithmException {
        MdSalt partOne = new MdSalt( "jlmsuwbz" );

        int result = partOne.start();

        assertEquals( 35186,result );
    }

    @Test
    void generate2016MdHashes() {
        String firstHash = salt.generateHash( "abc0",2016);


        assertEquals( "a107ff634856bb300138cac6568c0f24",firstHash );
    }
}