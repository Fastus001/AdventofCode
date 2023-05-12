package com.karczmarzyk.advent2017.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Checksum {

    public int sum(List<String> lines){
        return lines.stream()
                .map(this::convertString)
                .map(this::lineSum)
                .reduce(Integer::sum)
                .orElse(-1);

    }

    private List<Integer> convertString(String line){
        return Arrays.stream(line.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private int lineSum(List<Integer > line){
        Integer min = line.stream()
                .min(Integer::compareTo)
                .orElse(-1);
        Integer max = line.stream()
                .max(Integer::compareTo)
                .orElse(-1);
        return max-min;
    }

    public int sumPartTwo(List<String> lines){
        return lines.stream()
                .map(this::convertString)
                .map(this::divisible)
                .reduce(Integer::sum)
                .orElse(-1);

    }

    private int divisible(List<Integer> line){
        for (int i = 0; i < line.size(); i++) {
            for (int j = 0; j < line.size(); j++) {
                if(i != j){
                    if(line.get(i) % line.get(j) == 0){
                        return line.get(i) / line.get(j);
                    }
                }
            }
        }
        return -1;
    }
}
