package com.karczmarzyk.advent2020.day23;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Crab {
    private static final int SIZE = 9;
    private int round = 0;
    List<Integer> caps = new ArrayList<>();

    public Crab(String in) {
        for (int i = 0; i < in.length(); i++) {
            caps.add( Integer.parseInt( in.substring( i, i + 1 ) ) );
        }
    }

    public void round() {
        show();
        int currentCup = round % 9;
        System.out.println( "currentCup = " + currentCup );
        int cupNo = caps.get( currentCup );
        var pick = pickUp( currentCup );
        System.out.println( "pickup = " + pick );
        int destIndex = searchDestination(cupNo-1);
        System.out.println( "destIndex = " + destIndex );
        System.out.println("dest no = " + caps.get( destIndex ));
        if(destIndex>currentCup){
            caps.addAll( destIndex+1,pick );
        }else{
            var temp = caps.subList( 0, destIndex + 1 );
//            caps.removeAll( temp );
            Collections.reverse( temp );
            caps.addAll( temp );
            caps.addAll( pick );
            int s = caps.size();
            System.out.println( "size = " + s );
            if(caps.size()>SIZE){
                var tooMany = new ArrayList<>(caps.subList( SIZE, s ));
                caps.subList( SIZE, s ).clear();
                System.out.println(tooMany);
                caps.subList( 0,tooMany.size() ).clear();
                caps.addAll( 0,tooMany );

            }
        }


        System.out.println( "caps = " + caps );
        round++;
    }

    private int searchDestination(int dest) {
        int x = dest;
        if(x==0){
            x=9;
        }
        for (int i = 0; i < caps.size(); i++) {
            if(caps.get( i )==x){
                return i;
            }
        }
        return searchDestination( x-1 );
    }

    public List<Integer> pickUp(int index) {
        int start = index + 1;
        int end = index + 4;
        List<Integer> caps;
        if ( start <= SIZE && end <= SIZE ) {
            caps = this.caps.subList( start, end );
            return getSubList( caps );
        }else if( start < SIZE ){
            caps =  this.caps.subList( start,SIZE );
            caps.addAll( this.caps.subList( 0,end-SIZE ) );
            return getSubList( caps );
        }else{
            caps = this.caps.subList( start-SIZE,end-SIZE );
            return getSubList( caps );
        }
    }

    @NotNull
    private List<Integer> getSubList(List<Integer> caps) {
        List<Integer> temp = new ArrayList<>( caps );
        this.caps.removeAll( caps );
//        System.out.println( "this.caps sublist clear= " + this.caps );
        return temp;
    }

    public void show() {
        System.out.println("Round no -----"+(round+1)+"---------");
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
