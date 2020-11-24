package com.karczmarzyk.advent2015.Day22;

import java.util.ArrayList;
import java.util.List;

public class SpellCombinations {
    private static final String MM = "Magic Missile";
    private static final String DR = "Drain";
    private static final String SH = "Shield";
    private static final String PS = "Poison";
    private static final String RCHRG = "Recharge";
    private final List<List<String>> fullList = new ArrayList<>();

    public List<String> getFullListIndex(int index) {
        return fullList.get( index );
    }

    public int getFullListSize()
    {
        return fullList.size();
    }

    public void addNewSpells(List<List<String>> list, int counter)
    {
        if(counter == 0)
            return;
        else
        {
            List<List<String>> newList = new ArrayList<>();
            for(List<String> sb:list)
            {
                newList.add( getNewListWithNewString(sb,MM));
                newList.add( getNewListWithNewString(sb,DR));
                if(checkForEarlierPresence(sb,SH))
                    newList.add( getNewListWithNewString(sb,SH));

                if(checkForEarlierPresence(sb,PS))
                    newList.add( getNewListWithNewString(sb,PS));

                if(checkForEarlierPresence( sb,RCHRG ))
                newList.add( getNewListWithNewString(sb,RCHRG));
            }
            fullList.addAll( newList );
            addNewSpells( newList,--counter );
        }
    }

    private boolean checkForEarlierPresence(List<String> sb, String spell) {
        if(sb.get( sb.size()-1 ).equals( spell ))
        {
            return false;
        }
        return sb.size() <= 1 || !sb.get( sb.size() - 2 ).equals( spell );
    }

    private List<String> getNewListWithNewString(List<String> in,String mm) {
        List<String> temp = new ArrayList<>(in);
        temp.add( mm );
        return temp;
    }

    public List<List<String>> addFirstFive()
    {
        List<List<String>> list = new ArrayList<>();
        list.add( getNewListWithNewString(MM));
        list.add( getNewListWithNewString(DR));
        list.add( getNewListWithNewString(SH));
        list.add( getNewListWithNewString(PS));
        list.add( getNewListWithNewString(RCHRG));
        fullList.addAll( list );
        return list;
    }

    private List<String> getNewListWithNewString(String mm) {
        List<String> temp = new ArrayList<>();
        temp.add( mm );
        return temp;
    }

    public void show() {
        for(List<String> lst:fullList)
        {
            System.out.println( "lst = " + lst );
        }
    }

    public List<List<String>> getFullList() {
        return fullList;
    }
}
