package com.karczmarzyk.advent2022.day4;

import java.util.List;

public class CampCleanup {

    private final List<String> input;

    private int sumOfRangeFullyContain;
    private int sumOfRangeOverlap;

    public CampCleanup(List<String> input) {
        this.input = input;
        this.sumOfRangeFullyContain = 0;
        this.sumOfRangeOverlap = 0;
    }

    public int getFullyContained() {
        input.forEach(this::countIfContain);
        return sumOfRangeFullyContain;
    }

    public int getOverlapNumber() {
        input.forEach(this::countIfContain);
        return sumOfRangeOverlap;
    }


    private void countIfContain(String line) {
        final String[] split = line.split(",");
        String [] rangeOne = split[0].split("-");
        String [] rangeTwo = split[1].split("-");

        int a1 = Integer.parseInt(rangeOne[0]);
        int a2 = Integer.parseInt(rangeOne[1]);
        int b1 = Integer.parseInt(rangeTwo[0]);
        int b2 = Integer.parseInt(rangeTwo[1]);

        if(isInRange(a1, a2, b1, b2) || isInRange(b1, b2, a1, a2)){
            ++sumOfRangeFullyContain;
        }

        if(isOverlaping(a1, a2, b1, b2) || isOverlaping(b1, b2, a1, a2)){
            ++sumOfRangeOverlap;
        }
    }

    private static boolean isInRange(int a1, int a2, int b1, int b2) {
        return (a1 >= b1 && a1 <= b2) && (a2 <= b2 && a2 >= b1);
    }

    private static boolean isOverlaping(int a1, int a2, int b1, int b2) {
        return (a1 >= b1 && a1 <= b2) || (a2 <= b2 && a2 >= b1);
    }
}
