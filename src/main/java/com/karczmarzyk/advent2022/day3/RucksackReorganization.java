package com.karczmarzyk.advent2022.day3;

import java.util.Arrays;
import java.util.List;

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

    public int getCommonItemsPartTwo() {
        int sum = 0;
        for (int i = 0; i < input.size(); i = i + 3) {
            final String badgeLetter = getBadgeLetter(List.of(input.get(i), input.get(i + 1), input.get(i + 2)));
            sum += Priority.getPriority(badgeLetter);
        }
        return sum;
    }

    private String getBadgeLetter(List<String> groups) {
        final String second = groups.get(1);
        final String third = groups.get(2);
        return Arrays.stream(groups.get(0).split(""))
                .filter(letter -> second.contains(letter) && third.contains(letter))
                .findFirst().orElseThrow();
    }
}
