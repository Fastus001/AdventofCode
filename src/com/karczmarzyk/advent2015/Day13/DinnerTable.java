package com.karczmarzyk.advent2015.Day13;

import java.util.ArrayList;

public class DinnerTable {
    public static final String [] GUESTS = {"Alice","Bob","Carol","David"};
    public static ArrayList<String> PERMUTATIONS = new ArrayList<>();

    public static void main(String[] args) {
        generatePermutation(GUESTS.length, GUESTS);
        System.out.println("PERMUTATIONS = " + PERMUTATIONS);
    }

    private static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void generatePermutation(int k, String[] array)
    {
        if(k==1)
            PERMUTATIONS.add(String.join(",", array));
        else
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

}
