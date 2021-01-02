package com.karczmarzyk.advent2020.day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator;

    @BeforeEach
    void setUp() throws IOException {
        validator = new Validator("src/main/resources/2020/day19/rules.txt");
    }

    @Test
    void testSizeOfMap(){
        assertEquals(135,validator.getRuleMapSize());
    }

    @Test
    void checkMap() {
        validator.checkMap();
        validator.checkMap();
        validator.checkMap();
        validator.checkMap();
        validator.getRuleMap().forEach((s, rule) -> System.out.println("s + \" \"+ rule = " + s + "   "+ rule.toString()));

        System.out.println("42" + validator.getRule("42"));
        System.out.println("31" + validator.getRule("31"));
        System.out.println("size 131" +validator.getRule("131").getRulesFinalRules());
        System.out.println("size 61" + validator.getRule("61").getRulesFinalRules());
    }


    @Test
    void testTestCase() throws IOException {
        Validator test = new Validator("src/main/resources/2020/day19/test.txt");
        test.checkMap();
        test.checkMap();
        test.checkMap();
        test.checkMap();
        test.checkMap();
        test.getRuleMap().forEach((s, rule) -> System.out.println("s + \" \"+ rule = " + s + "   "+ rule.toString()));


    }
}