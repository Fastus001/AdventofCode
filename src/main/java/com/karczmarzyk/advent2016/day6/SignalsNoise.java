package com.karczmarzyk.advent2016.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SignalsNoise {
    private List<List<Character>> lst = new ArrayList<>();

    public SignalsNoise(String first) {
        char[] tab = first.toCharArray();
        for (char c : tab) {
            List<Character> temp = new ArrayList<>();
            temp.add( c );
            lst.add( temp );
        }
    }

    public void getNextLine(String line)
    {
        char[] tab = line.toCharArray();
        for (int i = 0; i < tab.length; i++) {
            lst.get( i ).add( tab[i] );
        }
    }

    public void getInput(String path){
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext())
            {
                getNextLine( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Character getCharacter(List<Character> in)
    {
        Map<Character, Long> collect = in.stream()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );
//        Long max = collect.values()
//                .stream()
//                .max( Long::compareTo )
//                .orElseThrow();

        Long min = collect.values()
                .stream()
                .min( Long::compareTo )
                .orElseThrow();

        Pair pair1 = collect.entrySet()
                .stream()
                .map( entry -> Pair.valueOf( entry.getKey(), entry.getValue() ) )
                .filter( pair -> pair.number == min )
                .findFirst()
                .orElseThrow();
        return pair1.character;
    }

    public String getText() {
        var res = new StringBuilder();
        for (List<Character> l:lst)
        {
            res.append( getCharacter( l ) );
        }
        return res.toString();
    }


    private static class Pair{
            private Character character;
            private  Long number;

         private Pair(Character character, Long number) {
             this.character = character;
             this.number = number;
         }

         public static Pair valueOf(Character character, Long l){
             return new Pair( character,l );
         }
     }

}
