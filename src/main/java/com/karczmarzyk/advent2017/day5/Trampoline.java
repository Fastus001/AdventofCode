package com.karczmarzyk.advent2017.day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.valueOf;

public class Trampoline {
    private int numberOfMoves = 0;
    private int maxLevel;
    private int currentLevel = 0;


    private final Map<Integer, Integer> jumps = new HashMap<>();

    public void loadData(List<String> data){
        for (int i = 0; i < data.size(); i++) {
            jumps.put(i, valueOf(data.get(i)));
        }
        maxLevel = data.size();
    }

    public int start(){
        while (currentLevel<maxLevel){
            Integer nextLevel = currentLevel + jumps.get(currentLevel);
            jumps.put(currentLevel, jumps.get(currentLevel)+1);
            currentLevel = nextLevel;
            numberOfMoves++;
        }
        return numberOfMoves;
    }
}
