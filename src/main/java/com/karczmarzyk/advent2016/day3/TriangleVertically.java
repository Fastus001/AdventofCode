package com.karczmarzyk.advent2016.day3;

import java.util.ArrayList;
import java.util.List;

public class TriangleVertically {

    public static int addLine(String line)
    {
        int result = 0;
        String[] tab = line.trim().split( "\\s+" );
        for (int i = 0; i < tab.length/3; i++) {
            List<Integer> list = new ArrayList<>();
            list.add( Integer.parseInt( tab[i] ) );
            list.add( Integer.parseInt( tab[i+3] ) );
            list.add( Integer.parseInt( tab[i+6] ) );
            list.sort( Integer::compareTo );
            if(list.get( 0 )+ list.get(1) > list.get(2))
                result++;
        }
        return result;
    }



}
