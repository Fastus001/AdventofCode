package com.karczmarzyk.advent2016.day9;

import org.jetbrains.annotations.NotNull;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Decompress {
    private static final Pattern PAT = Pattern.compile( "(\\(\\d+x\\d+\\))" );
    private final StringBuilder sb = new StringBuilder();


    public void decrypt(String in){
        MatchResult matchResult = PAT.matcher( in ).results().findFirst().orElse( null );
        if(matchResult == null){
            sb.append( in );
            return;
        }
        String[] xes = getSplit( matchResult );

        int length = Integer.parseInt( xes[0]);
        int multipleBy = Integer.parseInt( xes[1]);

        sb.append( in, 0, matchResult.start() );

        for (int i = 0; i < multipleBy; i++) {
            sb.append( in, matchResult.end(), matchResult.end()+length );
        }

        decrypt( in.substring( matchResult.end()+length ) );

    }

    @NotNull
    private String[] getSplit(MatchResult matchResult) {
        return matchResult.group()
                .replace( "(", "" )
                .replace( ")", "" )
                .split( "x" );
    }

    public String getSbString() {
        return sb.toString();
    }

    public long getSize()
    {
        return sb.toString().length();
    }
}
