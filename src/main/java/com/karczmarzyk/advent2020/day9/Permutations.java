package com.karczmarzyk.advent2020.day9;


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private final int SIZE;
    public List<Long> NUMBERS;

    public Permutations(int size) {
        SIZE = size;
    }

    public void setNUMBERS(List<Long> NUMBERS) {
        this.NUMBERS = NUMBERS;
    }

    private void helper(List<long[]> combinations, long[] data, int start, int end, int index)
    {
        if(index== data.length)
        {
            long[] combination = data.clone();
            combinations.add(combination);
        }else if(start <= end){
            data[index] = NUMBERS.get( start);
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    public List<long[]> generate()
    {
        List<long[]> combinations = new ArrayList<>();
        helper(combinations, new long[SIZE], 0, NUMBERS.size()-1,0);
        return combinations;
    }



}
