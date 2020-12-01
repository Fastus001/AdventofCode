package com.karczmarzyk.advent2016.day4;

import java.util.*;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.*;

public class Room {
    private static final Pattern PATTERN = Pattern.compile( "(.+)-(\\d+)\\[([a-z]+)]");
    private List<String> input;

    public Room(String input) {
        this.input = PATTERN.matcher( input )
                .results()
                .flatMap( this::groups )
                .collect( toList() );
    }

    public int getID()
    {
        String test = mapChars2();
        if(testRoom( test ))
        {
            return Integer.parseInt( input.get( 1 ) );
        }
        else
        {
            System.out.println( "input = " + input );
            return 0;
        }

    }

    public boolean testRoom(String mapChars)
    {
        if(mapChars.substring( 0,5 ).equals( input.get( 2 ) ))
            return true;
        return false;
    }


    public void show() {
        System.out.println( "input = " + input );
    }

    private Stream<String> groups(MatchResult mr)
    {
        return Stream.of( mr.group(1).replace( "-","" ),mr.group(2),mr.group(3));
    }


    public String mapChars2()
    {
        List<String> list = Collections.singletonList( input.get( 0 ) );
        Map<Character, Long> collect =
                list.stream()
                        .flatMap( s -> s.chars().mapToObj( c -> ( char ) c ) )
                        .collect( groupingBy( Function.identity(), counting() ) );

        Map<Long, List<Character>> collect1 =
                collect.entrySet()
                        .stream()
                        .collect( groupingBy(
                                Entry::getValue,mapping( Entry::getKey, toList() ) ) );


        List<Map.Entry<Long, List<Character>>> temp = new ArrayList<>(collect1.entrySet());

        temp.sort( Entry.comparingByKey(Comparator.reverseOrder()) );

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Long, List<Character>> e:temp)
        {
            List<Character> temp2 = e.getValue();
            temp2.sort( Character::compareTo );
            for(Character c:temp2)
                sb.append(c);


        }

        return sb.toString();
    }


}
