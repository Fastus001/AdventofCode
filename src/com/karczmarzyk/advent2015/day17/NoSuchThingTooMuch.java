package com.karczmarzyk.advent2015.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoSuchThingTooMuch {
    public static int [] NUMBERS = {7,10,11,18,18,21,22,24,26,32,36,40,40,42,43,44,46,47,49,50};
    public static final int K = 4;

    public static void main(String[] args) {
        NoSuchThingTooMuch ns = new NoSuchThingTooMuch();
        List<int[]> combinations = ns.generate(20, K);
        //PART 1 SOLUTION BELOW
//        combinations.addAll(ns.generate(20,5));
//        combinations.addAll(ns.generate(20,6));
//        combinations.addAll(ns.generate(20,7));
//        combinations.addAll(ns.generate(20,8));
        System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), 20, K);

    }

    private void helper(List<int[]> combinations, int[] data, int start, int end, int index)
    {
        if(index== data.length)
        {
            int[] combination = data.clone();
            int sum = Arrays.stream(combination).sum();
            if (sum==150)
                combinations.add(combination);
        }else if(start <= end){
            data[index] = NUMBERS[start];
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    public List<int[]> generate(int n, int k)
    {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[k], 0, n-1,0);
        return combinations;
    }


}
