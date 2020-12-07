package com.karczmarzyk.advent2020.day7;

import java.util.ArrayList;
import java.util.List;

public class LuggageList {
    private final List<Luggage> list;

    public LuggageList(List<Luggage> list) {
        this.list = list;
    }

    public void checkList(String nameToCheck){
        List<String> toCheck = new ArrayList<>();
        for(Luggage l:list)
        {
            if(!l.containsGold()){
                if(l.getOthers().contains( nameToCheck ))
                {
                    toCheck.add( l.getName() );
                    l.setContainsGold( true );
                }
            }
        }
        for(String s:toCheck){
            checkList( s );
        }
    }

    /*
    add in each luggage reference to the other luggage in the list...
     */
    public void luggageNumber()
    {
        for(Luggage l:list)
        {
            for(String other:l.getOthers())
            {
                for(Luggage lug: list){
                    if(lug.getName().equals( other ))
                    {
                        l.addOtherLuggage( lug );
                    }
                }
            }
        }
    }

    public long getNumberOfLuggageContainingShinyGold()
    {
        return list.stream().filter( Luggage::containsGold ).count();
    }

    public long getGoldLuggageNumber()
    {
        Luggage goldShiny = list.stream()
                .filter( luggage -> luggage.getName()
                .equals( "shiny gold" ) )
                .findFirst()
                .orElseThrow();
        return goldShiny.getLuggageNumber()-1;
    }
}
