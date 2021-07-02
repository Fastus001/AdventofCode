package com.karczmarzyk.advent2017.day7;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class Tower {
    private String name;
    private Integer weight;
    private Set<String> subTowers;

    public Tower(String name, Integer weight, Set<String> subTowers) {
        this.name = name;
        this.weight = weight;
        this.subTowers = subTowers;
    }

    public int getWeight(Map<String, Tower> towers) {
        int sum = subTowers.stream()
                .mapToInt(s->towers.get(s).getWeight(towers))
                .sum();
        return weight + sum;
    }
}
