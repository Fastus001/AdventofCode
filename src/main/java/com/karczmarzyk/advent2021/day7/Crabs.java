package com.karczmarzyk.advent2021.day7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Crabs {
    private List<Integer> positions;

    public Crabs(String positions) {
        this.positions = Arrays.stream(positions.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int computeBestAlign() {
        Integer max = positions.stream().max(Integer::compareTo).get();
        return Stream.iterate(0, i->i+1).limit(max)
                .mapToInt(this::alignTo)
                .min().orElse(-1);
    }

    private int alignTo(int target){
        return positions.stream()
                .map(integer -> Math.abs(integer-target))
                // part two
                .mapToInt(this::alignPartTwo)
                .sum();
    }

    private int alignPartTwo(Integer steps){
        if(steps == 0)
            return 0;
        return Stream.iterate(1,i->i+1).limit(steps)
                .reduce(Integer::sum)
                .get();
    }
}
