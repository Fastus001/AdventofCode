package com.karczmarzyk.advent2020.day19;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Rule {
    private static final Pattern NUM = Pattern.compile( "(\\d+)" );
    private static final int A = 52;
    private static final int B = 72;
    private final Validator validator;
    private boolean onlyLetters = false;
    private final List<Integer> rulesA;
    private List<Integer> rulesB = new ArrayList<>();

    public Rule(String in, Validator validator) {
        this.validator = validator;
        if ( in.contains( "|" ) ) {
            String[] split = in.split( "\\|" );
            rulesA = getIntegerList( split[0] );
            rulesB = getIntegerList( split[1] );
        }
        else {
            rulesA = getIntegerList( in );
        }
        checkLetters();
    }

    public String getRule(){
        String temp;
        if(onlyLetters){
            if(rulesB.isEmpty()){
                temp = "("+ getRulesAsString( rulesA ) +")";
            }else{
                temp = "("+ getRulesAsString( rulesA ) +"|"+ getRulesAsString( rulesB ) +")";
            }
            return temp.replace( Integer.toString(A),"a" ).replace( Integer.toString( B ),"b" );
        }else{
            if(rulesB.isEmpty()){
                temp= getRules( rulesA );
            }else{
                temp ="(" + getRules( rulesA ) +"|";
                temp+= getRules( rulesB ) +")";
            }
            return temp;
        }
    }

    @NotNull
    private String getRules(List<Integer> rulesA) {
        return rulesA.stream()
                .map( integer -> validator.getRule( integer ).getRule() )
                .collect( Collectors.joining() );
    }

    @NotNull
    private String getRulesAsString(List<Integer> rulesA) {
        return rulesA.stream().map( integer -> Integer.toString( integer ) )
                .collect( Collectors.joining() );
    }


    private void checkLetters() {
        List<Integer> temp = new ArrayList<>( rulesA );
        if ( !rulesB.isEmpty() ) {
            temp.addAll( rulesB );
        }
        long count = temp.stream()
                .filter( i -> !i.equals( A ) && !i.equals( B ) )
                .count();
        if ( count == 0 ) {
            onlyLetters = true;
        }
    }

    private List<Integer> getIntegerList(String input) {
        return NUM.matcher( input )
                .results()
                .map( MatchResult::group )
                .mapToInt( Integer::parseInt )
                .boxed()
                .collect( Collectors.toList() );
    }

    public boolean isOnlyLetters() {
        return onlyLetters;
    }
}
