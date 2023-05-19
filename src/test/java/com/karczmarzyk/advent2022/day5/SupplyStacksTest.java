package com.karczmarzyk.advent2022.day5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SupplyStacksTest {

    @Test
    void testInit() throws IOException {
        SupplyStacks ss = new SupplyStacks(List.of(
                List.of("Z", "N"),
                List.of("M", "C", "D"),
                List.of("P")
        ));

        final String result = ss.moveAllCrates(Files.readAllLines(Path.of("src/main/resources/2022/day5/test_input.txt")));

        assertThat(result).isEqualTo("CMZ");
    }

    @Test
    void testPartOne() throws IOException {
        SupplyStacks ss = new SupplyStacks(List.of(
                List.of("F", "H", "B", "V", "R", "Q", "D", "P"),
                List.of("L", "D", "Z", "Q", "W", "V"),
                List.of("H", "L", "Z", "Q", "G", "R", "P", "C"),
                List.of("R", "D", "H", "F", "J", "V", "B"),
                List.of("Z", "W", "L", "C"),
                List.of("J", "R", "P", "N", "T", "G", "V", "M"),
                List.of("J", "R", "L", "V", "M", "B", "S"),
                List.of("D", "P", "J"),
                List.of("D", "C", "N", "W", "V")
        ));

        final String result = ss.moveAllCrates(Files.readAllLines(Path.of("src/main/resources/2022/day5/input.txt")));

        assertThat(result).isEqualTo("JDTMRWCQJ");
    }


}
