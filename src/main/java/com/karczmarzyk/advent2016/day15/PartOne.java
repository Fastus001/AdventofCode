package com.karczmarzyk.advent2016.day15;

import java.util.ArrayList;
import java.util.List;

public class PartOne {

    public static void main(String[] args) {
        List<Disc> discs = new ArrayList<>();

        initValues( discs );
        for (int i = 0; i < 10_000_000; i++) {
            int positionAtTime = 0;
            for (int j = 0; j < discs.size(); j++) {
                positionAtTime += discs.get( j ).getPositionAtTime( i + j );
            }
            if(positionAtTime==0){
                System.out.println("Time: " + i);
                break;
            }
        }

    }

    private static void initValues(List<Disc> discs) {
        discs.add( new Disc( 17, 1 ) );
        discs.add( new Disc( 7, 0 ) );
        discs.add( new Disc( 19, 2 ) );
        discs.add( new Disc( 5, 0 ) );
        discs.add( new Disc( 3, 0 ) );
        discs.add( new Disc( 13, 5 ) );
        //part two element
        discs.add( new Disc( 11, 0 ) );
    }
}
