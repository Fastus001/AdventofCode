package com.karczmarzyk.advent2015.Day20;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class InfiniteHousesTest {
    @Test
    public void testHouse12() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> submit = executor.submit( new InfiniteHouses( 52 ) );
        assertEquals( 1067,submit.get());

        Future<Integer> submit1 = executor.submit( new InfiniteHouses( 102 ) );
        assertEquals( 2343,submit1.get());
    }

}