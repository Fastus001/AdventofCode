package com.karczmarzyk.advent2020.day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {
    Validator validator;

    @BeforeEach
    void setUp() throws IOException {
        validator = new Validator("src/main/resources/2020/day19/rules.txt");
    }

    @Test
    void testSizeOfMap(){

        assertEquals(135,validator.getRuleMapSize());
        assertEquals(426,validator.getMessages().size());

    }


    @Test
    void getRule() {
        assertEquals( 109,validator.checkMessagesPartOne());
    }
}