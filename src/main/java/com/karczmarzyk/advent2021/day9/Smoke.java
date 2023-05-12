package com.karczmarzyk.advent2021.day9;

import java.util.*;
import java.util.stream.Collectors;

public class Smoke {
    private List<List<Integer>> heightMap;
    private List<Integer> lowPoints = new ArrayList<>();
    private List<Integer> basinSizes = new ArrayList<>();
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

    public int getBasinSizesLargest() {
        Collections.sort(basinSizes, Comparator.reverseOrder());
        return basinSizes.stream().limit(3).reduce(1, (integer, integer2) -> integer * integer2);
    }

    private void checkLowPoint(int x, int y) {
        List<Integer> temp = new ArrayList<>();
        int number = heightMap.get(y).get(x);
        if (y > 0) {
            temp.add(heightMap.get(y - 1).get(x));
        }
        if (y < yMax - 1) {
            temp.add(heightMap.get(y + 1).get(x));
        }
        if (x > 0) {
            temp.add(heightMap.get(y).get(x - 1));
        }
        if (x < xMax - 1) {
            temp.add(heightMap.get(y).get(x + 1));
        }
        int min = temp.stream().min(Integer::compareTo).get();
        if (number < min) {
            lowPoints.add(number);
            basinSizes.add(computeBasinSize(y,x));
        }
    }

    private Integer computeBasinSize(int y, int x) {
        if (y < 0 || x < 0 || y == yMax || x == xMax) {
            return 0;
        }
        int number = heightMap.get(y).get(x);
        if (number < 0 || number == 9) {
            return 0;
        } else {
            heightMap.get(y).set(x, -1);
            int sum = 1 + computeBasinSize(y - 1, x);
            sum += computeBasinSize(y, x - 1);
            sum += computeBasinSize(y, x + 1);
            sum += computeBasinSize(y + 1, x);
            return sum;
        }
    }
}
