package com.karczmarzyk.advent2017.day7;

import java.util.List;
import java.util.stream.Collectors;

public class Circus {
    private final List<String> names;
    private final List<String> namesAbove;

    public Circus(List<String> input) {
        names = input.stream()
        .map(s -> s.split(" "))
        .map(arr->arr[0])
        .collect(Collectors.toList());

        namesAbove = input.stream()
                .map(s -> s.split(" -> "))
                .filter(array->array.length>1)
                .map(array->array[1])
                .collect(Collectors.toList());
    }

    public String findBottomProgram() {
        for (String name : names) {
            List<String> result = namesAbove.stream()
                    .filter(s -> s.contains(name))
                    .collect(Collectors.toList());
            if (result.size()==0){
                return name;
            }
        }
        return null;
    }
}
