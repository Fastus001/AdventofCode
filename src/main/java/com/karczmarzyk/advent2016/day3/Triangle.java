package com.karczmarzyk.advent2016.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Triangle {

    public static boolean isItTriangle(String input)
    {
        String[] tab = input.trim().split( "\\s+" );
        List<Integer> list = new ArrayList<>();
        for(String s:tab)
        {
            list.add( Integer.parseInt( s ) );
        }
        List<Integer> result = list.stream()
                .sorted()
                .collect( Collectors.toList() );
        return result.get( 0 )+ result.get(1) > result.get(2);
    }
}
