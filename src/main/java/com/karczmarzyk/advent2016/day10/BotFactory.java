package com.karczmarzyk.advent2016.day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotFactory {
    private static final Pattern VALUE = Pattern.compile( "value (\\d+).+(bot \\d+)" );
    private Map<String,Bot> botMap = new HashMap<>();

    public void addBots(List<Bot> bots){
        for (Bot bot : bots) {
            botMap.put( bot.getName(),bot );
        }
    }

    public void addValues(List<String> values){
        for (String value : values) {
            Matcher matcher = VALUE.matcher( value );
            if( matcher.find() ){
                botMap.get( matcher.group(2) ).addValue( Integer.parseInt( matcher.group(1)) );
            }
        }
    }

    public void addValue(String name, int value){
        if(botMap.containsKey( name )){
            Bot bot = botMap.get( name );
            bot.addValue(value);

        }
    }

    public String getBotNumber(int a, int b){
        return botMap.values().stream().filter( bot -> bot.getValues().contains( a ) && bot.getValues().contains( b ) )
                .findFirst().orElseThrow().getName();
    }

    public void checkBots(){
        botMap.values().stream().filter( Bot::isBothValues )
                .forEach( bot -> {
                    addValue( bot.getLow(), bot.getValue(true) );
                    addValue( bot.getHigh(), bot.getValue(false) );
                    });
        long count = botMap.values()
                .stream()
                .filter( bot -> !bot.isBothValues() )
                .count();

        if(count>0){
            checkBots();
        }
    }
}
