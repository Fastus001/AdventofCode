package com.karczmarzyk.utils;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private static int [] NUMBERS;
    public static final int K = 2;

   private static void helper(List<int[]> combinations, int[] data, int start, int end, int index)
    {
        if(index== data.length)
        {
            int[] combination = data.clone();
            combinations.add(combination);
        }else if(start <= end){
            data[index] = NUMBERS[start];
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    public static List<int[]> generateCombinations(int num)
    {
        NUMBERS = new int[num];
        for (int i = 0; i < num; i++) {
            NUMBERS[i] = i+1;
        }
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[K], 0, num-1,0);
        return combinations;
    }
}
