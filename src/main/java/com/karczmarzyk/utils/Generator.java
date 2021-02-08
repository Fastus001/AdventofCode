package com.karczmarzyk.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {
    private static int [] NUMBERS;
    public static ArrayList<List<String>> PERMUTATIONS = new ArrayList<>();
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

    public static void generatePermutation(int k, String[] array)
    {
        if(k==1) {
            List<String> collect =
                    Stream.of( array)
                            .collect( Collectors.toList());
            PERMUTATIONS.add(collect);
        } else
        {
            generatePermutation(k-1,array);
            for (int i = 0; i < k-1; i++) {
                if(k % 2 ==0)
                    swap(array,i,k-1);
                else
                    swap(array,0,k-1);
                generatePermutation(k-1,array);
            }
        }
    }

    private static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

}
