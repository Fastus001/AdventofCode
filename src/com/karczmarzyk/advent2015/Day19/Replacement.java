package com.karczmarzyk.advent2015.Day19;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Replacement {
    private  Pattern from;
    private  String into;
    private  final String text;
    List<Integer> startRanges;
    List<Integer> endRanges;

    public Replacement(String text) {
        this.text = text;
    }

    public ArrayList<String> loadReplacements(String from, String into)
    {
        this.from = Pattern.compile( "("+from +")");
        this.into = into;
        return getMolecules();
    }

    public void countOccurences() {
        startRanges = from.matcher( text )
                .results().map( MatchResult::start )
                .collect( Collectors.toList() );
        endRanges = from.matcher( text )
                .results().map( MatchResult::end )
                .collect( Collectors.toList() );
    }

    private ArrayList<String> getMolecules() {
        countOccurences();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < startRanges.size(); i++) {
            int start = startRanges.get( i );
            int end = endRanges.get( i );
            if( start == 0 )
            {
                list.add(into + text.substring( end));
            }else if(start > 0 && end < text.length())
            {
                list.add(text.substring( 0,start ) +
                                 into +
                                 text.substring( end));
            }else
            {
                list.add(text.substring( 0,start) +into);
            }
        }
        return list;
    }
}
