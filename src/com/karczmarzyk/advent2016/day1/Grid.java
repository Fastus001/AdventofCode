package com.karczmarzyk.advent2016.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private List<String> roseWind = new ArrayList<>( Arrays.asList( "West", "North", "East", "South"));
    private int x = 0;
    private int y = 0;
    private int direction = 1;

    public void getCoordinates(String co)
    {
        checkDirection( co );
        int distance = Integer.parseInt( co.substring( 1 ));
        addDisntance(distance);
    }

    private void addDisntance(int distance) {
        switch (direction)
        {
            case 0: x -=distance; break;
            case 1: y +=distance; break;
            case 2: x +=distance; break;
            case 3: y -=distance; break;
        }
    }

    private void checkDirection(String co) {

        if( co.charAt( 0 ) == 'R' )
        {
            direction++;
            if(direction==roseWind.size())
                direction = 0;
        }
        if( co.charAt( 0 ) == 'L' )
        {
            direction--;
            if(direction<0)
                direction = 3;
        }
    }

    public String getDirectionName() {
        return roseWind.get(direction);
    }

    public int getX() {
        return x;
    }

    public int getDistance() {
        return Math.abs( x )+Math.abs( y );
    }
}
