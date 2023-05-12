package com.karczmarzyk.advent2017.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void parseInput() {
        int[] ints = Util.parseInput("1,2,3");

        assertArrayEquals(new int[]{49, 44, 50, 44, 51, 17, 31, 73, 47, 23}, ints);
    }

    @Test
    void getXOR() {
        Integer xor = Util.getXOR(List.of(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22));

        assertEquals(64, xor);
    }

    @Test
    void toHex() {
        String result = Util.toHex(64);
        String result1 = Util.toHex(7);
        String result2 = Util.toHex(255);

        assertEquals("40",result);
        assertEquals("07",result1);
        assertEquals("ff",result2);
    }


}
