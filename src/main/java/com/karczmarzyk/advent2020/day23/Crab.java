package com.karczmarzyk.advent2020.day23;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Crab {
    private static final int SIZE = 9;
    List<Integer> caps = new ArrayList<>();

    public Crab(String in) {
        for (int i = 0; i < in.length(); i++) {
            caps.add( Integer.parseInt( in.substring( i, i + 1 ) ) );
        }
    }

    public void round(int round) {
        show( round );
        int currentCup = round % 9;
        System.out.println( "currentCup = " + currentCup );
        int cupNoCurrent = caps.get( currentCup );
        var pick = pickUp( currentCup );
        System.out.println( "pickup = " + pick );
        int destIndex = searchDestination( cupNoCurrent - 1 );
        System.out.println( "destIndex = " + destIndex );
        System.out.println( "dest no = " + caps.get( destIndex ) );

        caps.addAll( destIndex + 1, pick );


        if ( cupNoCurrent != caps.get( round % 9 ) ) {
            System.out.println( "Needs to change arrangement!!!!" );
            changeCaps( currentCup, cupNoCurrent );
        }

        System.out.println( "caps = " + caps );
    }

    private void changeCaps(int index, int cupNo) {
        int dif = index-caps.indexOf( cupNo );
        if(dif<0){
            var integers = new ArrayList<>(caps.subList( 0, Math.abs( dif ) ));
            caps.subList( 0, Math.abs( dif )).clear();
            caps.addAll( integers );
        }
        System.out.println( "dif = " + dif );
    }

    private int searchDestination(int dest) {
        int x = dest;
        if ( x == 0 ) {
            x = 9;
        }
        for (int i = 0; i < caps.size(); i++) {
            if ( caps.get( i ) == x ) {
                return i;
            }
        }
        return searchDestination( x - 1 );
    }

    public List<Integer> pickUp(int index) {
        int start = index + 1;
        int end = index + 4;
        List<Integer> caps;
        if ( start <= SIZE && end <= SIZE ) {
            caps = this.caps.subList( start, end );
            return getSubList( caps );
        }
        else if ( start < SIZE ) {
            caps = this.caps.subList( start, SIZE );
            caps.addAll( this.caps.subList( 0, end - SIZE ) );
            return getSubList( caps );
        }
        else {
            caps = this.caps.subList( start - SIZE, end - SIZE );
            return getSubList( caps );
        }
    }

    @NotNull
    private List<Integer> getSubList(List<Integer> caps) {
        List<Integer> temp = new ArrayList<>( caps );
        this.caps.removeAll( caps );
        return temp;
    }

    public void show(int round) {
        System.out.println( "Round no -----" + (round + 1) + "---------" );
        for (int i = 0; i < caps.size(); i++) {
            if ( i == round % 9 ) {
                System.out.print( "(" + caps.get( i ) + ")" );
            }
            else {
                System.out.print( caps.get( i ) );
            }
            System.out.print( " " );
        }
        System.out.println();
    }
}
