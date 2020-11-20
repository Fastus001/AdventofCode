package com.karczmarzyk.advent2015.Day20;

import java.util.concurrent.Callable;

public class InfiniteHouses implements Callable<Integer> {
    private int number;

    public InfiniteHouses(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum = 0;
            for (int j = 1; j <=number+i ; j++) {
                if((number+i)%j==0)
                    sum += j;
            }
            if(sum>3400000)
            {
                System.out.println( "number = " + (number+i) + " suma = " +(sum*10));
                break;
            }
        }
        return sum*10;
    }
}
