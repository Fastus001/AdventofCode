package com.karczmarzyk.advent2021.day5;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartOne {
    private final List<Line> lines;

    public PartOne(List<String> lines) {
        this.lines = lines.stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }


    public long getResult() {
        Map<Coordinate, Long> collect = lines.stream()
                .flatMap(line -> line.computeNonDiagonalCoordinates().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collect.values().stream().filter(v->v > 1)
                .count();
    }

    public long getResultPartTwo() {
        Map<Coordinate, Long> collect = lines.stream()
                .flatMap(line -> line.computeAll().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collect.values().stream().filter(v->v > 1)
                .count();
    }
}
