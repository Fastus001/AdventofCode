package com.karczmarzyk.advent2016.day9;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Compress {
    private static final Pattern PAT = Pattern.compile( "(\\(\\d+x\\d+\\))" );
    private long sum = 0;


    public void decrypt(String in) {
        final List<String> list = new ArrayList<>();
        MatchResult matchResult = PAT.matcher( in ).results().findFirst().orElse( null );
        if ( matchResult == null ) {
            sum += in.length();
            return;
        }
        String[] xes = getSplit( matchResult );

        int length = Integer.parseInt( xes[0] );
        int multipleBy = Integer.parseInt( xes[1] );

        sum += in.substring( 0, matchResult.start() ).length();
        for (int i = 0; i < multipleBy; i++) {
            list.add( in.substring( matchResult.end(), matchResult.end() + length ) );
        }
        list.add( in.substring( matchResult.end() + length ) );

        for (String s : list) {
            decrypt( s );
        }


    }

    @NotNull
    private String[] getSplit(MatchResult matchResult) {
        return matchResult.group()
                .replace( "(", "" )
                .replace( ")", "" )
                .split( "x" );
    }


    public long getSize() {
        return sum;
    }
}
