package com.karczmarzyk.advent2021.day14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PolymerAdvTest {

    @Test
    void getPairs() throws IOException {
        PolymerAdv adv = new PolymerAdv(Files.readAllLines(Path.of("src/main/resources/2021/day14/test.txt")));
        for (int i = 0; i < 39; i++) {
            adv.step();
        }

        System.out.println("adv.getPairs() = " + adv.getPairs());
        System.out.println("adv.getNoOfChars() = " + adv.getNoOfChars());

        Assertions.assertThat(adv.calculateResult()).isEqualTo(2188189693529L);
    }

    @Test
    void partTwo() throws IOException {
        PolymerAdv adv = new PolymerAdv(Files.readAllLines(Path.of("src/main/resources/2021/day14/input.txt")));
        for (int i = 0; i < 39; i++) {
            adv.step();
        }

        Assertions.assertThat(adv.calculateResult()).isEqualTo(4302675529689L);
    }
}