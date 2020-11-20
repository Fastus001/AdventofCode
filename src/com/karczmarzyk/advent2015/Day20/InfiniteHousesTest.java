package com.karczmarzyk.advent2015.Day20;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class InfiniteHousesTest {
    @Test
    public void testHouse12() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> submit = executor.submit( new InfiniteHouses( 51 ) );
        assertEquals( 781,submit.get());

    }

}