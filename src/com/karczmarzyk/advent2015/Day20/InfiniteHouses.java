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
        for (int j = 0; j < 1000; j++) {
            sum = 0;
            for (int i = 1; i <= number + j; i++) {
                if(i>(number+j-50))
                {
                    if ( (number + j) % i == 0 ){
//                        System.out.print(i + ",");
                        sum += i*11;
                    }
                }
            }
//            System.out.println( "number = " + (number + j) + " suma = " + (sum) );
            if ( sum > 34000000 ) {
                System.out.println( "number = " + (number + j) + " suma = " + (sum) );
                break;
            }
        }
        return sum;
    }
}
