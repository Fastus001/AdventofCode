package com.karczmarzyk.advent2020.day14;

import java.util.HashMap;
import java.util.Map;

public class DockingData {
    private final Bitmask bitmask = new Bitmask("");
    private final Map<Integer,Long> integerMap = new HashMap<>();

    public void setBitmaskMask(String  mask) {
        bitmask.setMask(mask);
    }

    public void addToMemory(int... line){
        integerMap.put(line[0],bitmask.convertNumberToBitString(line[1]));
    }

    public long getSumOfMem(){
        return integerMap.values()
                .stream()
                .reduce(Long::sum)
                .orElseThrow();
    }
}
