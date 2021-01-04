package com.karczmarzyk.advent2020.day19;

import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

class RuleTest {
    Validator validator;

    @BeforeEach
    void setValidator() throws IOException {
        validator = new Validator("src/main/resources/2020/day19/rules.txt");
    }


}