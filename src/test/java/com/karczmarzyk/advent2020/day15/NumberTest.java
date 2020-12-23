package com.karczmarzyk.advent2020.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    Number number;

    @BeforeEach
    void setUp() {
        number = new Number(0,1);
        number.addTimesSpoken(3);
        number.addTimesSpoken(5);
    }

    @Test
    void addTimesSpoken() {
        assertAll(()->assertEquals(3,number.getTurnNumberFirst()),
                ()->assertEquals(5,number.getTurnNumberSecond()));
    }

    @Test
    void getAge() {
        assertEquals(2,number.getAge());
    }
}