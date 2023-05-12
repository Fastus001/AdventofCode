package com.karczmarzyk.advent2021.day14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PolymerTest {

    @Test
    void transfer() throws IOException {
        Polymer polymer = new Polymer(Files.readAllLines(Path.of("src/main/resources/2021/day14/test.txt")));

        String result = "";
        for (int i = 0; i < 10; i++) {
            result = polymer.transfer();
        }

        Assertions.assertThat(result.length()).isEqualTo(3073);
        Assertions.assertThat(polymer.calculateResult()).isEqualTo(1588);
    }

    @Test
    void partOne() throws IOException {
        Polymer polymer = new Polymer(Files.readAllLines(Path.of("src/main/resources/2021/day14/input.txt")));
        int min = 30000;
        String result = "";
        for (int i = 0; i < 13; i++) {
            result = polymer.transfer();
            System.out.println("result = " + polymer.calculateResult());
            if(result.length()<min){
                System.out.println(result);
            }else {
                System.out.println(result.substring(0,min));
            }
            System.out.println("\n");
        }

        Assertions.assertThat(result.length()).isEqualTo(3073);
        Assertions.assertThat(polymer.calculateResult()).isEqualTo(3284);
    }
}