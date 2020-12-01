package com.karczmarzyk.advent2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportRepair {
    private static final List<Integer> INPUT = new ArrayList<>();


    public static void main(String[] args) {
        getInputData();
        for (int i = 0; i < INPUT.size(); i++) {
            for (int j = i+1; j < INPUT.size(); j++) {
                for (int k = j+1; k < INPUT.size(); k++) {
                    if ( INPUT.get( i ) + INPUT.get( j ) + INPUT.get(k) == 2020 ) {
                        long result = INPUT.get( i ) * INPUT.get( j )*INPUT.get(k);
                        System.out.println( "result = " + result );
                        break;
                    }
                }
            }
        }

    }

    private static void getInputData() {
        try (var in = new Scanner( new File( "src/main/resources/day1-2020.txt" ) )) {
            while (in.hasNext()) {
                INPUT.add( in.nextInt() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
