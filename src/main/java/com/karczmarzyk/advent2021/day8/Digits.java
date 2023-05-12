package com.karczmarzyk.advent2021.day8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Digits {
    private final List<List<String>> displays;

    public Digits(List<String> displays) {
        this.displays = displays.stream().map(d->d.split(" \\| ")[1])
                .map(line-> Arrays.stream(line.split(" ")).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public long countDigits() {
        return displays.stream()
                .mapToLong(list->list.stream().filter(s->s.length()==2 || s.length()==3 || s.length()==4 || s.length()==7   )
                        .count())
                .sum();
    }
}
