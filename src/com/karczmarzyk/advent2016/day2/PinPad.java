package com.karczmarzyk.advent2016.day2;

import java.util.Arrays;

public class PinPad {
    private final int [][] pinPad = new int[3][3];
    private int x = 1;
    private int y = 1;

    public PinPad() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pinPad[i][j] = ++counter;
            }
            
        }
    }

    private void getMove(char c)
    {
        if(c == 'U' && y > 0)
        {
            y--;
        }
        if(c == 'D' && y < 2)
        {
            y++;
        }
        if(c == 'R' && x < 2)
        {
            x++;
        }
        if(c == 'L' && x > 0)
        {
            x--;
        }
    }

    public void show() {
        System.out.println( "Arrays.deepToString( pinPad) = " + Arrays.deepToString( pinPad) );
    }

    public int getString(String ull) {
        char [] tab = ull.toCharArray();
        for (char c : tab) {
            getMove( c );

        }

        return pinPad[y][x];
    }

}
