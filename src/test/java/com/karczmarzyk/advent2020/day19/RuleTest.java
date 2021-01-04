package com.karczmarzyk.advent2020.day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {
    Validator validator;

    @BeforeEach
    void setValidator() throws IOException {
        validator = new Validator("src/main/resources/2020/day19/testCases.txt");
    }


    @Test
    void isOnlyLetters() {
        Rule rule = validator.getRule( 25 );
        Rule rule3 = validator.getRule( 52 );

        assertFalse( rule.isOnlyLetters() );
        assertTrue( rule3.isOnlyLetters() );
    }

    @Test
    void getRule() {
        Rule rule = validator.getRule( 45 );

        assertEquals( "(ba|ab)",rule.getRule() );
    }

}