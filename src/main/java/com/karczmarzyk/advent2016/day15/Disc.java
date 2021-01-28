package com.karczmarzyk.advent2016.day15;

public class Disc {
    private final int positions;
    private final int startPos;

    public Disc(int positions, int startPos) {
        this.positions = positions;
        this.startPos = startPos;
    }

    public int getPositionAtTime(int time) {
        return (startPos + time+1) % positions;
    }
}
