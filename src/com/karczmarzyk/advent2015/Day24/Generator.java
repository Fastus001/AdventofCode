package com.karczmarzyk.advent2015.Day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generator {
    private final List<Integer> numbers;


    public Generator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void helper(List<int[]> combinations, int[] data, int start, int end, int index)
    {
        if(index== data.length)
        {
            int[] combination = data.clone();
            int sum = Arrays.stream( combination).sum();
            if (sum==520){
                combinations.add(combination);
            }
        }else if(start <= end){
            data[index] = numbers.get( start);
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    public List<int[]> generate(int k)
    {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[k], 0, numbers.size() -1,0);
        return combinations;
    }
}
