package com.karczmarzyk.advent2016.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SslSupportTest {

    SslSupport support;

    @BeforeEach
    void setSupport()
    {
        support = new SslSupport();
    }

    @Test
    void isTextIsABA() {
        support.isSslSupported( "aba[bab]xyz" );
    }

    @Test
    void isSslSupported() {
        assertTrue( support.isSslSupported( "aba[bab]xyz" ) );
        assertFalse( support.isSslSupported( "xyx[xyx]xyx" ) );
        assertTrue( support.isSslSupported( "aaa[kek]eke" ) );
        assertTrue( support.isSslSupported( "zazbz[bzb]cdb" ) );
    }

    @Test
    void shouldbeOk()
    {
        assertTrue( support.isSslSupported( "wbpogjbyzelmxqeaazu[djdqdlmpfmezzehvjl]qdquppvgjweftqvph[equcifktaceuqwoakk]uxemheczqpboerwq" ) );
        assertTrue( support.isSslSupported( "gfgrgtizxajkaicjcc[mftrzuftzrgrwilsv]uckwgxywnamzjglbnts" ) );
    }
}