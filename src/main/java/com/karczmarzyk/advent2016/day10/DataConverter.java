package com.karczmarzyk.advent2016.day10;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

public class DataConverter {
    private static final Pattern BOT = Pattern.compile( "(\\d)" );
    private Bot[] botList =  new Bot[209];

    public void createBot(String line){
        List<String> collect = BOT.matcher( line )
                .results()
                .map( MatchResult::group )
                .collect( toList() );

        Bot temp = new Bot( parseInt( collect.get(1) ) ,
                            parseInt( collect.get(2) )) ;

        botList[parseInt( collect.get( 0))] = temp;
    }
}
