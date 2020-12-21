package com.karczmarzyk.advent2020.day13;

import java.util.Map;
import java.util.TreeMap;

public class TimeStamp {
    private int depart;
    private Map<Integer,Integer> buses = new TreeMap<>();

    public TimeStamp(int depart) {
        this.depart = depart;
    }

    public void addBus(int bus){
        buses.put(getMinutesToDepart(bus),bus);
    }

    public int getMinutesToDepart(int bus){
        int i = depart % bus;
        return bus-i;
    }

    public int getMinIDValue(){
        return buses.entrySet()
                .stream()
                .findFirst()
                .map(i -> i.getKey() * i.getValue())
                .orElseThrow();
    }
}
