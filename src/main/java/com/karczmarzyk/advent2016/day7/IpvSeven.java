package com.karczmarzyk.advent2016.day7;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IpvSeven {
    private static final Pattern ABBA = Pattern.compile( "(.)(.)\\2\\1" );
    private static final Pattern BRACKETS = Pattern.compile( "(\\[[a-z]+\\])" );

    public boolean isIpCorrect(String ip) {
        Matcher matcher = ABBA.matcher( ip );
        if ( !matcher.find() )
            return false;
        else {
            String inBracketText = BRACKETS.matcher( ip )
                    .results()
                    .map( MatchResult::group )
                    .collect( Collectors.joining() );

            if ( !isTextCorrect( inBracketText ) ) {
                return isTextCorrect( ip );
                }
            }
        return false;
        }

    public boolean isTextCorrect(String s) {
        final List<String> collect = ABBA.matcher( s ).results().map( MatchResult::group )
                .collect( Collectors.toList() );
        if(collect.size()==0) {
            return false;
        }

        for(String line:collect)
        {
            if(line.charAt( 0 ) == line.charAt( 1 ))
                return false;
        }
        return true;
    }


}
