package com.karczmarzyk.advent2022.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RucksackReorganization {

    private final List<String> input;

    public RucksackReorganization(List<String> input) {
        this.input = input;
    }


    public int getCommonItems() {
        return input.stream()
                .map(this::getCommonItem)
                .mapToInt(Priority::getPriority)
                .sum();
    }

    private String getCommonItem(String line) {
        final int middleIndex = line.length() / 2;
        final String firstHalf = line.substring(0, middleIndex);
        final String rest = line.substring(middleIndex);
        return Arrays.stream(firstHalf.split(""))
                .filter(rest::contains)
                .findFirst().orElseThrow();
    }
}
