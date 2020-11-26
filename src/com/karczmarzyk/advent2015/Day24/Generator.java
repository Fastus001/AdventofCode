package com.karczmarzyk.advent2015.Day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generator {
    private final List<Long> numbers;


    public Generator(List<Long> numbers) {
        this.numbers = numbers;
    }

    private void helper(List<List<Long>> combinations, Long[] data, int start, int end, int index)
    {
        if(index== data.length)
        {
            List<Long> combination = List.of(data);
            Long sum = combination.stream().reduce( Long::sum ).orElseThrow();
            if (sum==520){
                combinations.add(combination);
            }
        }else if(start <= end){
            data[index] = numbers.get( start);
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    public List<List<Long>> generate(int k)
    {
        List<List<Long>> combinations = new ArrayList<>();
        helper(combinations, new Long[k], 0, numbers.size() -1,0);
        return combinations;
    }
}
