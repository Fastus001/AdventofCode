package com.karczmarzyk.advent2022.day3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class RucksackReorganizationTest {

    @Test
    void getCommonItemsTestSample() throws IOException {
        RucksackReorganization rr = new RucksackReorganization(Files.readAllLines(Path.of("src/main/resources/2022/day3/day3-test.txt")));

        var totalPriority = rr.getCommonItems();

        Assertions.assertThat(totalPriority).isEqualTo(157);
    }

    @Test
    void getCommonItemsPartOne() throws IOException {
        RucksackReorganization rr = new RucksackReorganization(Files.readAllLines(Path.of("src/main/resources/2022/day3/day3.txt")));

        var totalPriority = rr.getCommonItems();

        Assertions.assertThat(totalPriority).isEqualTo(8401);
    }

    @Test
    void getCommonItemsTestSamplePartTwo() throws IOException {
        RucksackReorganization rr = new RucksackReorganization(Files.readAllLines(Path.of("src/main/resources/2022/day3/day3-test.txt")));

        var totalPriority = rr.getCommonItemsPartTwo();

        Assertions.assertThat(totalPriority).isEqualTo(70);
    }

    @Test
    void getCommonItemsPartTwo() throws IOException {
        RucksackReorganization rr = new RucksackReorganization(Files.readAllLines(Path.of("src/main/resources/2022/day3/day3.txt")));

        var totalPriority = rr.getCommonItemsPartTwo();

        Assertions.assertThat(totalPriority).isEqualTo(2641);
    }
}
