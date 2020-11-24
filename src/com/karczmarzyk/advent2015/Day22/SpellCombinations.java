package com.karczmarzyk.advent2015.Day22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpellCombinations {
    private static final String MM = "Magic Missile";
    private static final String DR = "Drain";
    private static final String SH = "Shield";
    private static final String PS = "Poison";
    private static final String RCHRG = "Recharge";
    private final List<StringBuilder> fullList = new ArrayList<>();

    public StringBuilder getFullListIndex(int index) {
        return fullList.get( index );
    }

    public int getFullListSize()
    {
        return fullList.size();
    }

    public void addNewSpells(List<StringBuilder> list, int counter)
    {
        if(counter == 0)
            return;
        else
        {
            List<StringBuilder> newList = new ArrayList<>();
            for(StringBuilder sb:list)
            {
                newList.add( new StringBuilder(sb + ","+MM ));
                newList.add( new StringBuilder(sb + ","+DR ));
                newList.add( new StringBuilder(sb + ","+SH ));
                newList.add( new StringBuilder(sb + ","+PS ));
                newList.add( new StringBuilder(sb + "," + RCHRG ));
            }
            fullList.addAll( newList );
            addNewSpells( newList,--counter );
        }
    }

    public List<StringBuilder> addFirstFive()
    {
        List<StringBuilder> list = new ArrayList<>();
        list.add( new StringBuilder("Magic Missile") );
        list.add( new StringBuilder("Drain") );
        list.add( new StringBuilder("Shield") );
        list.add( new StringBuilder("Poison") );
        list.add( new StringBuilder("Recharge") );
        return list;
    }

    public List<String> getFullList() {
        return fullList.stream()
                .map( StringBuilder::toString )
                .collect( Collectors.toList() );
    }
}
