package com.karczmarzyk.advent2017.day7;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class TowerManager {
    private static final int TOWER_NUMBER = 1178;
    private Map<String, Tower> towers = new HashMap<>();

    public TowerManager(List<String> towersNames) {
        towersNames.stream()
                .map(this::createTower)
                .forEach(tower -> towers.put(tower.getName(), tower));
    }

    public void showWeight(String name){
        Tower tower = towers.get(name);
        tower.getSubTowers().forEach(s -> System.out.println(s + " = " + towers.get(s).getWeight(towers)));
    }

    private Tower createTower(String line){
        if(line.contains("->")){
            return createSubTower(line);
        }
        return createEndTower(line);
    }

    private Tower createEndTower(String line){
        String[] sp = line.split(" ");
        return new Tower(sp[0], Integer.valueOf(sp[1]), Set.of());
    }

    private Tower createSubTower(String line) {
        String[] half = line.split(" -> ");
        Tower tower = createEndTower(half[0]);
        tower.setSubTowers(Set.of(half[1].split(", ")));

        return tower;
    }
}
