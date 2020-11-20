package com.karczmarzyk.advent2015.Day19;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Replacement {
    private  Pattern from;
    private  String into;
    private  String text;
    int numberOfOccurrences;

    public Replacement(String text) {
        this.text = text;
    }

    public void loadReplacements(String from, String into)
    {
        this.from = Pattern.compile( "("+from +")");
        this.into = into;
        text = getNumberOfChanges();
    }

    public void countOccurrences() {
        numberOfOccurrences += ( int ) from.matcher( text )
                .results().map( MatchResult::start ).count();
    }

    private String getNumberOfChanges() {
        countOccurrences();
        return text.replaceAll( from.pattern(),into );
    }

    public int getNumberOfOccurrences() {
        return numberOfOccurrences;
    }

    public boolean isDoubleE() {
        Pattern pattern = Pattern.compile( "(e)" );
        long count = pattern.matcher( text )
                .results().map( MatchResult::start ).count();
        return count > 1;
    }

    public void showText()
    {
        System.out.println( "text = " + text + "\nnumber of steps = " + numberOfOccurrences
        + "\n length = " + textSize());
    }

    public int textSize()
    {
        return text.length();
    }
}
