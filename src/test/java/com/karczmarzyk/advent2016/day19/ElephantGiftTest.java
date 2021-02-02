package com.karczmarzyk.advent2016.day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElephantGiftTest {
    ElephantGift gift;

    @BeforeEach
    void setUp() {
        gift = new ElephantGift( 5 );
    }

    @Test
    void removeSeats() {
        assertEquals( 3,gift.removeSeats());
    }

    @Test
    void testPartOne() {
        ElephantGift partOne = new ElephantGift( 3001330 );

        int result = partOne.removeSeats();

        assertEquals( 1808357,result);
    }
}