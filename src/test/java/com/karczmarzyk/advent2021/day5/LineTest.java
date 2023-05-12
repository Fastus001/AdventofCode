package com.karczmarzyk.advent2021.day5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {


    @Test
    void computeCoordinates() {
        Line line = new Line("0,9 -> 5,9");

        List<Coordinate> coordinates = line.computeNonDiagonalCoordinates();
        System.out.println("coordinates = " + coordinates);

        Assertions.assertThat(coordinates).hasSize(6);
    }
}