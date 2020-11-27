package com.karczmarzyk.advent2015.day20;

import java.util.concurrent.Callable;

public class InfiniteHouses implements Callable<Integer> {
    private final int number;

    public InfiniteHouses(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        int result = Integer.MAX_VALUE;
        int sum;
        for (int j = 0; j < 1000; j++) {
            sum = 0;
            for (int i = 1; i <= number + j; i++) {
                if ( (number + j) % i == 0 ){
                    if((number+j)/i <= 50)
                        sum += i*11;
                }
            }
            if ( sum > 34000000 ) {
                result = number + j;
                System.out.println( "number = " + (number + j) + " suma = " + (sum) );
                break;
            }
        }
        return result;
    }
}
