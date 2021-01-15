package com.karczmarzyk.advent2020.day23;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CrabAdv {
    private static final int SIZE = 1_000_000;
//    private static final int SIZE = 9;

    private int lastIndex = 0;
    List<Integer> caps = new LinkedList<>();

    public CrabAdv(String in) {
        for (int i = 0; i < SIZE; i++) {
            if(i<in.length()){
                var i1 = Integer.parseInt( in.substring( i, i + 1 ));
                caps.add(  i1 );
            }else{
                caps.add( i+1 );
            }
        }
    }

    public void round(int round) {
//        show( round );
//        System.out.println( "lastIndex = " + lastIndex );
        int currentCup = round % SIZE;
//        int currentCup = round;
//        System.out.println("current index = " + currentCup);
        int cupNoCurrent = caps.get( currentCup );
//        System.out.println( "cupNoCurrent = " + cupNoCurrent );
        var pick = pickUp( currentCup );
//        System.out.println( "pick = " + pick );
        int destIndex;
//        if(caps.get( lastIndex ) == cupNoCurrent-1){
////            System.out.println("tutaj");
//            caps.addAll( lastIndex + 1, pick );
//        }else{
            destIndex = searchDestination( cupNoCurrent - 1 );
//            System.out.println( "destIndex = " + destIndex );
            caps.addAll( destIndex + 1, pick );
//            lastIndex = destIndex;
//        }


        if ( cupNoCurrent != caps.get( round % SIZE ) ) {
            changeCaps( currentCup, cupNoCurrent );
        }
//        show( round );
    }

    private void changeCaps(int index, int cupNo) {
        int dif = index-caps.indexOf( cupNo );
        if(dif<0){
            var integers = new LinkedList<>(caps.subList( 0, Math.abs( dif ) ));
            caps.subList( 0, Math.abs( dif )).clear();
            caps.addAll( integers );
        }
    }

    private int searchDestination(int dest) {
        int x = dest;
        if ( x == 0 ) {
            x = SIZE;
        }
        var i = caps.indexOf( x );
//        System.out.println( "i = " + i );
        return i!=-1?i:searchDestination( x - 1 );

    }

    public List<Integer> pickUp(int index) {
        int start = index + 1;
        int end = index + 4;
        List<Integer> temp;
        if ( start <= SIZE && end <= SIZE ) {
            temp = new ArrayList<>(caps.subList( start, end ));
            caps.removeAll( temp );
            return  temp;
        }
        else if ( start < SIZE ) {
            temp = caps.subList( start, SIZE );
            temp.addAll( caps.subList( 0, end - SIZE ) );
            return getSubList( temp );
        }
        else {
            temp = caps.subList( start - SIZE, end - SIZE );
            return getSubList( temp );
        }
    }

    @NotNull
    private List<Integer> getSubList(List<Integer> caps) {
        List<Integer> temp = new LinkedList<>( caps );
        this.caps.removeAll( temp );
        return temp;
    }

    public void show(int round) {
        System.out.println( "Round no -----" + (round) + "---------" );
        for (int i = 0; i < 50; i++) {
            if ( i == round % SIZE ) {
                System.out.print( "(" + caps.get( i ) + ")" );
            }
            else {
                System.out.print( caps.get( i ) );
            }
            System.out.print( " " );
        }
//        System.out.print( "///" );
//        for (int i = SIZE-50; i < SIZE; i++) {
//            if ( i == round % SIZE ) {
//                System.out.print( "(" + caps.get( i ) + ")" );
//            }
//            else {
//                System.out.print( caps.get( i ) );
//            }
//            System.out.print( " " );
//        }
//        System.out.println();
    }

    public String getNumber() {
        var split = caps.stream()
                .map( i -> Integer.toString( i ) )
                .collect( Collectors.joining() )
                .split( "1" );
        return split[1]+split[0];
    }

    public String getTwoAfterOne(){
        var in = new StringBuilder();
        boolean check = false;
        int s = 0;
        for (Integer cap : caps) {
            if(s==3){
                break;
            }
            if ( cap.equals( 1 ) ){
                check = true;
            }
            if(check){
                in.append( cap ).append( "," );
            }
            if(check){
                s++;
            }

        }
        return in.toString();
    }
}
