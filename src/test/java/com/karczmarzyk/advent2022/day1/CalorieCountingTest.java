package com.karczmarzyk.advent2022.day1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCountingTest {

    @Test
    void getMaxTotalCaloriesTestCase() throws IOException {
        CalorieCounting cc = new CalorieCounting();

        final Integer maxTotalCalories = cc.getMaxTotalCalories(Files.readAllLines(Path.of("src/main/resources/2022/day1/day1-2022test.txt")));

        Assertions.assertThat(maxTotalCalories).isEqualTo(24000);
    }

    @Test
    void getMaxTotalCaloriesPart1() throws IOException {
        CalorieCounting cc = new CalorieCounting();

        final Integer maxTotalCalories = cc.getMaxTotalCalories(Files.readAllLines(Path.of("src/main/resources/2022/day1/day1-2022.txt")));

        Assertions.assertThat(maxTotalCalories).isEqualTo(66186);
    }

    @Test
    void getMaxTotalCaloriesPart2() throws IOException {
        CalorieCounting cc = new CalorieCounting();

        final Integer maxTotalCalories = cc.getMaxTotalCaloriesPart2(Files.readAllLines(Path.of("src/main/resources/2022/day1/day1-2022.txt")));

        Assertions.assertThat(maxTotalCalories).isEqualTo(196804);
    }
}
