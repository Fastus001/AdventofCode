package com.karczmarzyk.advent2021.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Smoke {
    private List<List<Integer>> heightMap;
    private List<Integer> lowPoints = new ArrayList<>();
    private int xMax;
    private int yMax;

    public Smoke(List<String> input) {
        heightMap = input.stream().map(s -> Arrays.stream(s.split("")))
                .map(str -> str.map(Integer::parseInt).collect(Collectors.toList()))
                .collect(Collectors.toList());
        xMax = heightMap.get(0).size();
        yMax = heightMap.size();
    }

    public int computeRiskLevel() {
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                checkLowPoint(x, y);
            }
        }

        return lowPoints.stream().mapToInt(i -> i + 1).sum();
    }

    private void checkLowPoint(int x, int y) {
        List<Integer> temp = new ArrayList<>();
        int number = heightMap.get(y).get(x);
//        System.out.println(number);
        if (y > 0) {
            temp.add(heightMap.get(y - 1).get(x));
        }
        if (y < yMax-1) {
            temp.add(heightMap.get(y + 1).get(x));
        }
        if (x > 0) {
            temp.add(heightMap.get(y).get(x -1));
        }
        if (x < xMax-1) {
            temp.add(heightMap.get(y).get(x + 1));
        }
        int min = temp.stream().min(Integer::compareTo).get();
        if (number < min) {
            lowPoints.add(number);
        }
    }
}
