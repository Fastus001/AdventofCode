package com.karczmarzyk.advent2016.day10;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotFactory {
    private static final Pattern VALUE = Pattern.compile( "value (\\d+).+(bot \\d+)" );
    private final Map<String,Bot> botMap = new HashMap<>();

    public void addBots(List<Bot> bots){
        for (Bot bot : bots) {
            botMap.put( bot.getName(),bot );
        }
    }

    public void addValueInstructions(List<String> values){
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

    public String getBotName(int chipA, int chipB){
        return botMap.values()
                .stream()
                .filter( bot -> bot.getValues().contains( chipA ) && bot.getValues().contains( chipB ) )
                .findFirst()
                .orElseThrow()
                .getName();
    }

    public void checkBots(){
        botMap.values()
                .stream()
                .filter( Bot::isBothValues )
                .forEach( sendOutput() );

        long count = botMap.values()
                .stream()
                .filter( bot -> !bot.isBothValues() )
                .count();

        if(count>0){
            checkBots();
        }
    }

    @NotNull
    private Consumer<Bot> sendOutput() {
        return bot -> {
            addValue( bot.getLow(), bot.getValue( true ) );
            addValue( bot.getHigh(), bot.getValue( false ) );
        };
    }

    public Map<String, Bot> getBotMap() {
        return botMap;
    }
}
