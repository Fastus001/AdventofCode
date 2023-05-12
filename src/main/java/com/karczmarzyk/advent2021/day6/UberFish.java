package com.karczmarzyk.advent2021.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UberFish {
    private Map<Integer, Long> pool = new HashMap<>();

    public UberFish(String input) {
        this.pool.put(0, 0L);
        this.pool.put(1, 0L);
        this.pool.put(2, 0L);
        this.pool.put(3, 0L);
        this.pool.put(4, 0L);
        this.pool.put(5, 0L);
        this.pool.put(6, 0L);
        this.pool.put(7, 0L);
        this.pool.put(8, 0L);
        Map<Integer, Long> collect = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        this.pool.putAll(collect);
    }

    public void oneDay() {
        Long temp = pool.get(0);
        pool.put(0, pool.get(1));
        pool.put(1, pool.get(2));
        pool.put(2, pool.get(3));
        pool.put(3, pool.get(4));
        pool.put(4, pool.get(5));
        pool.put(5, pool.get(6));
        pool.put(6, pool.get(7)+temp);
        pool.put(7, pool.get(8));
        pool.put(8, temp);
    }

    public Long howMuchIsTheFish(){
        return pool.values().stream().reduce(Long::sum).get();
    }
}
