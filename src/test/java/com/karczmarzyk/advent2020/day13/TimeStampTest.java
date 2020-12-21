package com.karczmarzyk.advent2020.day13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampTest {
    TimeStamp stamp;

    @BeforeEach
    void setUp() {
        stamp = new TimeStamp(939);
    }

    @Test
    void getMinutesToDepart() {
        assertEquals(5,stamp.getMinutesToDepart(59));
    }

    @Test
    void getMinIDValue() {
        stamp.addBus(7);
        stamp.addBus(13);
        stamp.addBus(59);
        stamp.addBus(31);
        stamp.addBus(19);
        assertEquals(295,stamp.getMinIDValue());
    }

    @Test
    void testPartOne(){
        TimeStamp timeStamp = new TimeStamp(1008169);
        timeStamp.addBus(29);
        timeStamp.addBus(41);
        timeStamp.addBus(37);
        timeStamp.addBus(653);
        timeStamp.addBus(13);
        timeStamp.addBus(17);
        timeStamp.addBus(23);
        timeStamp.addBus(823);
        timeStamp.addBus(19);
        assertEquals(4938,timeStamp.getMinIDValue());
    }
}