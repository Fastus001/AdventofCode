package com.karczmarzyk.advent2016.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataConverter {
    private static final Pattern BOT = Pattern.compile( "(bot \\d+) gives low to ([botup]+ \\d+) and high to ([botup]+ \\d+)" );
    private List<String> inputList = new ArrayList<>();

     public List<Bot> getBotList(){
        return inputList.stream().filter( s -> !s.contains( "value" ) )
                .map( DataConverter::convertBots )
                .collect( Collectors.toList());
    }

    public List<String> getValues(){
        return inputList.stream().filter( s -> s.contains( "value" ) )
                .collect( Collectors.toList());
    }


    private static Bot convertBots(String line){
        Matcher matcher = BOT.matcher( line );
        if(matcher.find())
            return new Bot( matcher.group( 1 ), matcher.group( 2 ), matcher.group( 3 ) );
        return null;
    }

    public void setInputList(List<String> inputList) {
        this.inputList = inputList;
    }
}
