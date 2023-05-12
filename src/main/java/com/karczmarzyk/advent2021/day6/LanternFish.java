package com.karczmarzyk.advent2021.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LanternFish {
    private List<Integer> pool;

    public LanternFish(String input) {
        this.pool = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void oneDay() {
        pool = pool.stream().map(integer -> integer -=1).collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        for (Integer integer : pool) {
            if (integer.equals(-1)) {
                temp.add(8);
            }
        }
        pool = pool.stream().map(integer -> {
            if(integer == -1){
                return 6;
            }
            return integer;
        }).collect(Collectors.toList());
        pool.addAll(temp);
    }

    public int howMuchIsTheFish(){
        return pool.size();
    }
}
