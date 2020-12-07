package com.karczmarzyk.advent2020.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Luggage {
    private static final Pattern SPLIT = Pattern.compile( "([a-z]+ [a-z]+)" );
    private static final Pattern NUM = Pattern.compile( "(\\d)" );

    private String luggage;
    private List<String> others = new ArrayList<>();
    private List<Luggage> otherLuggage = new ArrayList<>();
    private List<Integer> numberOfLuggage = new ArrayList<>();
    private boolean containsGold = false;
    private int caseNumber = -1;

    public Luggage(String luggage) {
        String [] temp = luggage.split( " bags contain " );
        List<String> collect = SPLIT.matcher( temp[1] )
                .results()
                .map( MatchResult::group )
                .collect( toList() );
        if(collect.get( 0 ).equals( "no other" ))
        {
            this.caseNumber = 1;
        }else{
                numberOfLuggage = NUM.matcher( temp[1] )
                        .results()
                        .map( MatchResult::group )
                        .map(Integer::parseInt)
                        .collect( toList() );
        }

        this.luggage = temp[0];
        others.addAll( collect );
    }

    public String getLuggage() {
        return this.luggage;
    }

    public boolean containsGold() {
        return containsGold;
    }

    public String getName() {
        return this.luggage;
    }

    public List<String> getOthers() {
        return others;
    }

    public void setContainsGold(boolean containsGold) {
        this.containsGold = containsGold;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "luggage='" + luggage + '\'' +
                '}';
    }

    public void addOtherLuggage(Luggage luggage){
        otherLuggage.add( luggage );
    }

    public int getLuggageNumber(){
        if(caseNumber ==1)
            return 1;
        int sum = 1;
        for (int i = 0; i < otherLuggage.size(); i++) {
            sum += numberOfLuggage.get( i )*otherLuggage.get( i ).getLuggageNumber();
        }
        return sum;
    }




}
