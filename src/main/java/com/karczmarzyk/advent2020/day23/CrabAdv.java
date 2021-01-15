package com.karczmarzyk.advent2020.day23;

import java.util.HashMap;
import java.util.Map;

public class CrabAdv {
    private static final int SIZE = 1_000_000;
//    private static final int SIZE = 9;
    private final Map<Integer,Cup> cupMap = new HashMap<>();
    private Cup start = null;


    public CrabAdv(String  input) {
        Cup previous = null;
        for (int i = 1; i <= SIZE; i++) {
            int x;
            if(i<=9){
                x = Integer.parseInt( input.substring( i-1,i ));
            }else{
                x = i;
            }
             Cup temp = new Cup( x,previous,null );
            if(previous!=null){
                previous.setNext( temp );
            }
            if(i==1){
                start = temp;
            }
            cupMap.put( temp.getNumber(), temp );
            previous = temp;
        }
        assert start != null;
        start.setPrevious( previous );
        previous.setNext( start );
    }

    public void pickUp(){
        //pick up three cups next to HEAD
        Cup first = start.getNext();
        Cup third = first.getNext().getNext();

        Cup nextStart = third.getNext();

        start.setNext( third.getNext() );
        third.getNext().setPrevious( start );

        //search number lower than START
        int number = start.getNumber();

        Cup destination = cupMap.get( checkNextThree(number-1,first) );

        moveToDestination( first, third, destination );

        //start -> nowy start
        start = nextStart;

    }

    private void moveToDestination(Cup one, Cup three, Cup destination) {
        //put three in destination
        Cup temp = destination.getNext();
        destination.setNext( one );
        one.setPrevious( destination );

        three.setNext( temp );
        temp.setPrevious( three );
    }

    private int checkNextThree(int i, Cup one) {
        if(i==0){
            i = SIZE;
        }
        if(one.getNumber().equals( i ) || one.getNext().getNumber().equals( i ) ||
                one.getNext().getNext().getNumber().equals( i ) ){
            return checkNextThree( i-1,one );
        }
        return i;
    }

    public Map<Integer, Cup> getCupMap() {
        return cupMap;
    }

    public long getFinalNumber() {
        var cup = cupMap.get( 1 );

        return ( long ) cup.getNext().getNumber() * cup.getNext().getNext().getNumber();
    }

   }
