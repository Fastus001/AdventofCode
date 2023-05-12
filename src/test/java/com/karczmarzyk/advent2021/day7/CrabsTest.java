package com.karczmarzyk.advent2021.day7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CrabsTest {

    @Test
    void alignTo() {
        Crabs crabs = new Crabs("16,1,2,0,4,2,7,1,2,14");

        int result = crabs.computeBestAlign();

//        Assertions.assertThat(result).isEqualTo(37);
        Assertions.assertThat(result).isEqualTo(168);
    }

    @Test
    void partOne() throws IOException {
        Crabs crabs = new Crabs(Files.readAllLines(Path.of("src/main/resources/2021/day7/input.txt")).get(0));

        int result = crabs.computeBestAlign();

//        Assertions.assertThat(result).isEqualTo(335330);
        Assertions.assertThat(result).isEqualTo(92439766);
    }
}