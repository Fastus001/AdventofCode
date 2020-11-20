package com.karczmarzyk.advent2015.Day20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InfiniteElves {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Integer>> lista = new ArrayList<>();
        for (int i = 12; i < 20; i+=10) {
            lista.add( new InfiniteHouses( i ) );
        }
        executor.invokeAll( lista );
        executor.shutdown();
        System.out.println("tutaj");
    }
}
