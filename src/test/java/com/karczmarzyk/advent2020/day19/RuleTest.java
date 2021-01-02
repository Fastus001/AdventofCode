package com.karczmarzyk.advent2020.day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {
    Validator validator;

    @BeforeEach
    void setValidator() throws IOException {
        validator = new Validator("src/main/resources/2020/day19/rules.txt");
    }

    @Test
    void testConstructor(){
        Rule rule = new Rule(" 72 52");
        Rule rule2 = new Rule(" 4 1 5");
        Rule rule3 = new Rule(" 128 72 | 106 52");

        System.out.println("rule.getRules() = " + rule.getRulesFinalRules());
        System.out.println("rule.getRules() = " + rule2.getRules());
        System.out.println("rule.getRules() = " + rule3.getRules());
        assertTrue(rule.isOnlyLetters());
    }


    @Test
    void getRules() {
        Rule rule128 = new Rule(" 72 | 52");
        Rule rule2 = new Rule(" 128 72 | 117 52");
        rule2.addNewRules(rule128.getRulesFinalRules(),"128");
        System.out.println("rule2.getRules() = " + rule2.getRules());
    }

    @Test
    void getRulesFinalRules() {
        Rule rule128 = new Rule(" 72 | 52");
        List<String> rulesFinalRules = rule128.getRulesFinalRules();
        System.out.println(rulesFinalRules);

    }

    @Test
    void addNewRules() {
        Rule rule = new Rule(" 113 72 | 113 52");
        rule.addNewRules(validator.getRule("113").getRules(),"113");
        System.out.println("rule = " + rule);
    }

    @Test
    void getNumber() {
        Rule rule = new Rule(" 113 0 | 113 1");
        rule.getNumber();
    }
}