package com.karczmarzyk.advent2015.day24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Balance {
    public static final List<Long> NUMBERS = new ArrayList<>();
    public static final int K = 4;

    //part 1 - only three groups, need one filter only and the weight is 520 for each group
    // part 2 - four groups, need two filters used and the weight of each group is 390
    public static void main(String[] args) {
        Balance.getInput();
        Generator balance = new Generator(NUMBERS);
        List<List<Long>> combinations = balance.generate(K);

        System.out.println( "combinations.size() = " + combinations.size() );

        List<List<Long>> resultOne = combinations.stream()
                .filter( Balance::checkIfPossibleToPlacePackages )
                .filter( Balance::checkIfPossibleToPlacePackages )
                .collect( Collectors.toList() );

        long minQuantumEntanglement = resultOne.stream()
                .mapToLong( Balance::quantumEntanglement )
                .min()
                .orElseThrow();
        System.out.println( "minQuantumEntanglement = " + minQuantumEntanglement );
    }

    private static long quantumEntanglement(List<Long> list)
    {
        return list.stream()
                .reduce( ((aLong, aLong2) -> aLong*aLong2))
                .orElseThrow();
    }

    private static boolean checkIfPossibleToPlacePackages(List<Long> list)
    {
        List<Long> result = Balance.removeNumbers( list);
        Generator balanceAfter = new Generator(result);
        List<List<Long>> combinationsAfter;
        for (int i = 3; i < result.size(); i++) {
            combinationsAfter = balanceAfter.generate(i);
            if(combinationsAfter.size()>0)
                return true;
        }
        return false;
    }

    private static void getInput() {
        try(var in = new Scanner( new File( "src/com/karczmarzyk/advent2015/resources/day24.txt" ) ))
        {
            while(in.hasNext())
            {
                NUMBERS.add( in.nextLong() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Long> removeNumbers(List<Long> numbers)
    {
        List<Long> temp = new ArrayList<>( NUMBERS );
        temp.removeAll( numbers );

        return temp;
    }

}
