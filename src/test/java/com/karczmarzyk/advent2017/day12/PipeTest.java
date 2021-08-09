package com.karczmarzyk.advent2017.day12;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

class PipeTest {
    DigitalPlumber dp;

    @BeforeEach
    void setUp() {
        dp = new DigitalPlumber(List.of(
                "0 <-> 2", "1 <-> 1", "2 <-> 0, 3, 4","3 <-> 2, 4", "4 <-> 2, 3, 6",
                "5 <-> 6", "6 <-> 4, 5"));
    }
}
