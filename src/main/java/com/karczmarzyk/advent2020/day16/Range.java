package com.karczmarzyk.advent2020.day16;

public class Range {
    private int min;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isValid(int x) {
        return x >= min && x <= max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
