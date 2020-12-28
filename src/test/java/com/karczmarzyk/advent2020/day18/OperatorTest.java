package com.karczmarzyk.advent2020.day18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void evaluateExpression() {
        assertEquals(71, Operator.evaluateExpression("1 + 2 * 3 + 4 * 5 + 6"));
    }

    @Test
    void getParentheses() {
        long parentheses = Operator.getParentheses("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2");
        assertEquals(13632,parentheses);
    }
}