package com.karczmarzyk.advent2020.day13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampAdvTest {
    TimeStampAdv adv = new TimeStampAdv("29,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,37,x,x,x,x,x,653,x,x,x,x,x,x,x,x,x,x,x,x,13,x,x,x,17,x,x,x,x,x,23,x,x,x,x,x,x,x,823,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,19");
//    TimeStampAdv adv = new TimeStampAdv("41,x,x,x,37,x,x,x,x,x,653,x,x,x,x,x,x,x,x,x,x,x,x,13,x,x,x,17,x,x,x,x,x,23,x,x,x,x,x,x,x,823");
//    TimeStampAdv adv = new TimeStampAdv("29,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,37,x,x,x,x,x,653");
//    TimeStampAdv adv = new TimeStampAdv("7,13,x,x,59,x,31,19");

    @Test
    void findFirstTimeStamp() {
        assertEquals(230903629977901l,adv.findFirstTimeStamp());
    }
}