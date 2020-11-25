package com.karczmarzyk.advent2015.Day24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Balance {
    public static List<Integer> NUMBERS = new ArrayList<Integer>();
    public static final int K = 6;


    public static void main(String[] args) {
        Balance.getInput();
        Generator balance = new Generator(NUMBERS);
        List<int[]> combinations = balance.generate(K);
        for(int[] in :combinations)
        {
            System.out.println( "Arrays.toString( in = " + Arrays.toString( in ));
        }
        System.out.println( "combinations.size() = " + combinations.size() );
    }

    private static void getInput() {
        try(var in = new Scanner( new File( "src/com/karczmarzyk/advent2015/resources/day24.txt" ) ))
        {
            while(in.hasNext())
            {
                NUMBERS.add( in.nextInt() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
