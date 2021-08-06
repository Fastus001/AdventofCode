package com.karczmarzyk.advent2017.day11;

import lombok.Data;

import java.util.*;

@Data
public class HexEd {
    private int sides = 0;
    private int up = 0;
    private String input;
    private final List<String> tab = new LinkedList<>();

    public HexEd(String input) {
        this.input = input;
    }

    public void convertString() {
        input = input.replace(",n,s,",",");
        input = input.replace(",s,n,",",");
        input = input.replace(",ne,sw,",",");
        input = input.replace(",sw,ne,",",");
        input = input.replace(",nw,se,",",");
        input = input.replace(",se,nw,",",");
        input = input.replace(",ne,nw,",",n,");
        input = input.replace(",nw,ne,",",n,");
        input = input.replace(",se,sw,",",s,");
        input = input.replace(",sw,se,",",s,");
    }

    public int getSteps() {
        convertString();
        convertString();
        convertString();
        String[] split = input.split(",");
        System.out.println("split = " + split.length);
        for (String s : split) {
            moveThroughGrid(s.trim());
//            System.out.println("s = " + s);
        }
        System.out.println("sides = " + sides);
        System.out.println("up = " + up);
        return (Math.abs(sides)+Math.abs(up)/2);
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
    }
}
