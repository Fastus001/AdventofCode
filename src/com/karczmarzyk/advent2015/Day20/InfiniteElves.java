package com.karczmarzyk.advent2015.Day20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InfiniteElves {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Integer>> lista = new ArrayList<>();
        for (int i = 830000; i < 850000; i+=1000) {
            lista.add( new InfiniteHouses( i ) );
        }
        List<Future<Integer>> futures = executor.invokeAll(lista);
        executor.shutdown();
        Integer minVal = futures.stream()
                .map(InfiniteElves::getFutureValue)
                .min(Integer::compareTo)
                .orElse(-1);

        System.out.println("min = " + minVal);
        System.out.println("tutaj");
    }

    private static Integer getFutureValue(Future<Integer> futures) {
        Integer result = 0;
        try {
            result = futures.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
