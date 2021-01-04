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
    void testConstructor(){
        Rule rule = validator.getRule( 50 );

//        assertEquals("(b)",rule.getRule());
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
        Rule rule2 = validator.getRule( 42 );

        assertEquals( "(ba|ab)",rule.getRule() );
        assertEquals( "((b)(b)|(b|a)(a))",rule2.getRule() );
    }

    @Test
    void testSampleInput() throws IOException {
        Validator valid = new Validator( "src/main/resources/2020/day19/test.txt" );

        Rule rule = valid.getRule( 0 );
        assertEquals( "((b)(b)|(b|a)(a))",rule.getRule() );
    }

}