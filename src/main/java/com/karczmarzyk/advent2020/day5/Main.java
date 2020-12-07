package com.karczmarzyk.advent2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Integer> SEATS = new ArrayList<>();
    public static void main(String[] args) {
        getInput();
        Integer max = SEATS.stream()
                .max( Comparator.naturalOrder() )
                .orElseThrow();

        System.out.println( "Part 1 - max = " + max );
        SEATS.sort( Comparator.naturalOrder() );
        for (int i = 0; i < SEATS.size()-1; i++) {
            if(SEATS.get( i+1 )-SEATS.get( i ) > 1)
                System.out.println("Part 2 - " + (SEATS.get( i+1)-1));
        }
    }

    private static void getInput() {
        try(var in =  new Scanner( new File( "src/main/resources/2020/day5/day5.txt" ) ))
        {
            BinaryBoarding boarding = new BinaryBoarding();
            while (in.hasNext())
            {
                String line = in.nextLine();
                SEATS.add( Integer.parseInt( boarding.setBits( line ) ));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
