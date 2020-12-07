package com.karczmarzyk.advent2020.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CustomAdvanced extends Custom{
    private static int size = 0;

    public static long getInput(String input){
        String [] tab = input.split( " " );
        size = tab.length;
        if(size==1){
            return Custom.countCustomQuestions( input.replace( " ","" ) );
        }
        else{
           List<Character> charsList = getCharsList( getStreamList( tab ) );

            Map<Character, Long> charMap = charsList.stream()
                    .collect( groupingBy( Function.identity(), counting() ) );

            return getCountOfSameAnswer( charMap );
        }
    }

    @org.jetbrains.annotations.NotNull
    private static List<Stream<Character>> getStreamList(String[] tab) {
        List<Stream<Character>> streamList = new ArrayList<>();
        for (String s : tab) {
            streamList.add( Custom.streamOfChars( s.toCharArray() ) );
        }
        return streamList;
    }

    private static long getCountOfSameAnswer(Map<Character, Long> charMap) {
        return charMap.entrySet()
                .stream()
                .filter( CustomAdvanced::checkValue )
                .count();
    }

    private static List<Character> getCharsList(List<Stream<Character>> streamList) {
        return streamList.stream()
                .map( characterStream -> characterStream.collect( toList() ) )
                .reduce( CustomAdvanced::sumOfLists )
                .orElseThrow();
    }

    public static List<Character> sumOfLists(List<Character> s1, List<Character> s2){
        s1.addAll( s2 );
        return s1;
    }

    public static boolean checkValue(Map.Entry<Character, Long> entry){
        return entry.getValue() == size;
    }
}
