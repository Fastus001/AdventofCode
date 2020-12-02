package com.karczmarzyk.advent2020.day2;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Password {
    private static final Pattern PATTERN = Pattern.compile( "(\\d+)-(\\d+) ([a-z]): ([a-z]+)" );
    private final List<String> input;

    public Password(String line) {
        this.input = PATTERN.matcher( line )
                .results()
                .flatMap( this::groups )
                .collect( toList() );
    }

    public boolean isPasswordValid()
    {
        int min = Integer.parseInt( input.get( 0 ));
        int max = Integer.parseInt( input.get( 1 ));
        char c = input.get( 2 ).charAt( 0 );
        char [] tab = input.get( 3 ).toCharArray();
        int counter = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] == c)
                counter++;
        }
        return counter >=min && counter <=max;
    }

    private Stream<String> groups(MatchResult mr) {
        return Stream.of( mr.group( 1 ), mr.group( 2 ), mr.group( 3 ),mr.group( 4 ) );
    }
}
