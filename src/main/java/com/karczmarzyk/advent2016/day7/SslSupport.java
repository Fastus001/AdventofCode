package com.karczmarzyk.advent2016.day7;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SslSupport {
    private static final Pattern ABA = Pattern.compile( "([a-z])([a-z])\\1" );
    private static final Pattern ABA_EXT = Pattern.compile( "([a-z])([a-z])\\1([a-z])\\1" );

    private static final Pattern BRACKETS = Pattern.compile( "(\\[[a-z]+\\])" );
    private String inBracketText = "";

    public boolean isTextIsABA(String text)
    {
        final List<String> collect = ABA.matcher( text )
                .results()
                .map( MatchResult::group )
                .collect( Collectors.toList() );
        if(collect.size()==0) {
            return false;
        }

        for(String line:collect)
        {
            String invert = line.substring( 1 ) + line.charAt( 1 );
            if(inBracketText.contains( invert ))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isSslSupported(String input)
    {
        inBracketText = BRACKETS.matcher( input )
                .results()
                .map( MatchResult::group )
                .collect( Collectors.joining() );

        String rest = BRACKETS.matcher( input ).replaceAll( "-=" );

        Matcher matcher = ABA_EXT.matcher( rest );
        if( matcher.find() ){
            if(isTextIsAbaExtended( rest ))
                return true;
        }
        return isTextIsABA( rest );
    }

    private boolean isTextIsAbaExtended(String in) {
        final List<String> collect = ABA_EXT.matcher( in )
                .results()
                .map( MatchResult::group )
                .collect( Collectors.toList() );

        for (String line : collect) {
            String two = line.substring( 3 ) + line.charAt( 3 );
            if ( inBracketText.contains( two ) )
                return true;
            }
        return false;
        }

}
