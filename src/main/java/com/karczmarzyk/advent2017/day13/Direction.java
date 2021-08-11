package com.karczmarzyk.advent2017.day13;

public enum Direction {
    UP(1), DOWN(-1);

    public final int step;

    Direction(int step) {
        this.step = step;
    }
}
