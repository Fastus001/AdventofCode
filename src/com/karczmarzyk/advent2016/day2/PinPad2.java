package com.karczmarzyk.advent2016.day2;

import java.util.Arrays;

public class PinPad2 {
    private  String [] pinPad2 = new String[5];
    private int x = 0;
    private int y = 2;

    public PinPad2() {
        pinPad2[0] = "  1  ";
        pinPad2[1] = " 234 ";
        pinPad2[2] = "56789";
        pinPad2[3] = " ABC ";
        pinPad2[4] = "  D  ";
    }

    private void getMove(char c)
    {
        if(c == 'U' && y > 0)
        {
            if( isPinEmpty( 0, -1 ) )
                y--;
        }
        if(c == 'D' && y < 4)
        {
            if(isPinEmpty( 0,1 ))
                y++;
        }
        if(c == 'R' && x < 4)
        {
            if(isPinEmpty( 1,0 ))
                x++;
        }
        if(c == 'L' && x > 0)
        {
            if( isPinEmpty( -1,0 ) )
                x--;
        }
    }

    private boolean isPinEmpty(int x1 , int y1) {
        return pinPad2[y + y1].charAt( x + x1 ) != ' ';
    }

    public void show() {
        for (String s : pinPad2) {
            System.out.println( "pinPad2[i] = " + s );
        }
    }

    public String getString(String ull) {
        char [] tab = ull.toCharArray();
        for (char c : tab) {
            getMove( c );
//            System.out.println(getCurrentChar());
        }

        return pinPad2[y].substring( x, x+1);
    }

    public char getCurrentChar()
    {
        return pinPad2[y].charAt( x );
    }
}
