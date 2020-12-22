package com.karczmarzyk.advent2020.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    Decoder decoder;

    @BeforeEach
    void setUp() {
        decoder = new Decoder("00000000000000000000000000000000X0XX");
    }

    @Test
    void setMask() {
    }

    @Test
    void convertNumberToBitString() {
        assertEquals("00000000000000000000000000000001X0XX",decoder.convertNumberToBitString(26));
    }

    @Test
    void getFloating() {
        List<String> floating = decoder.getFloating(Collections.singletonList(decoder.convertNumberToBitString(26)));
        assertEquals(8,floating.size());
    }
}