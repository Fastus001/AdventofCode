package com.karczmarzyk.advent2022.day1;

import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class CalorieCounting {
    private Set<Integer> elfsCalories = new HashSet<>();

    public Integer getMaxTotalCalories(List<String> input) {
        addCaloriesToSet(input);
        return elfsCalories.stream()
                .mapToInt(Integer::intValue)
                .max().orElseThrow();
    }

    public Integer getMaxTotalCaloriesPart2(List<String> input) {
        addCaloriesToSet(input);
        return elfsCalories.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void addCaloriesToSet(List<String> input) {
        AtomicInteger total = new AtomicInteger(0);

        input.forEach(line -> {
            if(line.length() == 0) {
                elfsCalories.add(total.intValue());
                total.set(0);
            } else {
                total.set(total.addAndGet(Integer.parseInt(line)));
            }
        });
    }

}
