package com.karczmarzyk.advent2016.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private final List<String> roseWind = new ArrayList<>( Arrays.asList( "West", "North", "East", "South"));
    private int x = 0;
    private int y = 0;
    private int direction = 1;
    private final List<String> coordinates = new ArrayList<>();

    public Grid()
    {
        coordinates.add( Integer.toString( 0 )+0 );
    }

    public int getCoordinates(String co)
    {
        checkDirection( co );
        int distance = Integer.parseInt( co.substring( 1 ));
        for (int i = 1; i <=distance ; i++) {
            addDisntance();
            String xy = Integer.toString( x )+y;
            if(coordinates.contains( xy ))
                return getDistance();
            else
             coordinates.add( xy );
        }

        return -1;
    }

    private void addDisntance() {
        switch (direction)
        {
            case 0: x -= 1; break;
            case 1: y += 1; break;
            case 2: x += 1; break;
            case 3: y -= 1; break;
        }
    }

    private void checkDirection(String co) {

        if( co.charAt( 0 ) == 'R' )
        {
            direction++;
            if(direction==roseWind.size())
                direction = 0;
        }else{
            direction--;
            if(direction<0)
                direction = 3;
        }
    }

    public String getDirectionName() {
        return roseWind.get(direction);
    }

    public int getDistance() {
        return Math.abs( x )+Math.abs( y );
    }
}
