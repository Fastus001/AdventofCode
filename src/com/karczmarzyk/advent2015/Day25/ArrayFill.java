package com.karczmarzyk.advent2015.Day25;

import java.util.Arrays;

public class ArrayFill {
    private final int [][] tab = new int[10][10];
    private static final int ROW = 4;
    private static final int COL = 2;

    public void fillFirstTen()
    {
        int counter = 1;
        tab[0][0] = counter;

        for (int i = 1; i < 10; i++) {
            int x = 0;
            for (int j = i; j >=0 ; j--,x++) {
                tab[j][x] = ++counter;
                if(j == ROW-1 && x == COL-1 )
                    return;
            }

        }
    }
    
    public void showTab()
    {
        for (int[] ints : tab) {
            System.out.println( "tab = " + Arrays.toString( ints ) );
        }
    }
}
