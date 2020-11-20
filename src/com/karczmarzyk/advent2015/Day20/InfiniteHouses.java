package com.karczmarzyk.advent2015.Day20;

import java.util.concurrent.Callable;

public class InfiniteHouses implements Callable<Integer> {
    private final int number;

    public InfiniteHouses(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        int sum = 0;
        if(number<51)
        {
            for (int i = 1; i <= number; i++) {
                if(number % i == 0)
                    sum+=i;
             }
        }
        else{
                for (int i = number-49; i <= number; i++) {
                    System.out.println(i);
                    if(number % i == 0)
                      sum+=i;
                }
            }
        return sum*11;
    }
}
