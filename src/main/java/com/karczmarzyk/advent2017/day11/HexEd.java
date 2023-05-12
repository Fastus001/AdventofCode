package com.karczmarzyk.advent2017.day11;

import lombok.Data;

@Data
public class HexEd {
    private int sides = 0;
    private int up = 0;
    private String input;
    private int max = 0;

    public HexEd(String input) {
        this.input = input;
    }

    public int getSteps() {
        String[] split = input.split(",");
        for (String s : split) {
            moveThroughGrid(s.trim());
        }
        return getDistance();
    }

    private int getDistance() {
        int sideDistance = Math.abs(sides);
        int verticalDistance = Math.abs(up);

        return sideDistance >= verticalDistance ? sideDistance : (verticalDistance-sideDistance)/2+sideDistance;
    }

    private void moveThroughGrid(String direction) {
        switch (direction) {
            case "n": up+=2; break;
            case "ne": sides++; up++; break;
            case "nw": sides--; up++; break;
            case "se": sides++; up--; break;
            case "sw": sides--; up--; break;
            case "s": up -=2; break;
            default: throw new IllegalArgumentException("Ups-" + direction + "-");
        }
        int currentDistance = getDistance();
        if (currentDistance > max) {
            max = currentDistance;
        }
    }
}
