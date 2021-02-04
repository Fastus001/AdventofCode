package com.karczmarzyk.advent2016.day19;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class GiftAcross {
    private final Map<Integer,Seat> seatMap = new HashMap<>();
    private Seat currentSeat;
    private Seat searchSeat;
    private int size;

    public GiftAcross(int size) {
        for (int i = 1; i <=size ; i++) {
            seatMap.put( i,new Seat( i ) );
        }
        seatMap.forEach( linkSeats() );
        seatMap.get( 1 ).joinPrevious( seatMap.get( size ) );
        currentSeat = seatMap.get( 1 );
        this.size =size;
    }

    @NotNull
    private BiConsumer<Integer, Seat> linkSeats() {
        return (integer, seat) -> {
            if(integer < seatMap.size()){
                seat.joinNext( seatMap.get( integer + 1 ) );
            }
        };
    }

    public void checkAcrossFirstSieve(){
        int noOfMoves = (size / 2);
        searchSeat = seatMap.get( noOfMoves++ );
//        System.out.println( "searchSeat = " + searchSeat );
        while (searchSeat.getNumber()<size){
            searchSeat = seatMap.get( noOfMoves++ );
//            System.out.println( "searchSeat = " + searchSeat );
            searchSeat.previous.joinNext( searchSeat.next );
            seatMap.remove( searchSeat.getNumber() );
            currentSeat = currentSeat.getNext();
            size--;

            searchSeat = seatMap.get( noOfMoves++ );
//            System.out.println( "searchSeat = " + searchSeat );
            searchSeat.previous.joinNext( searchSeat.next );
            seatMap.remove( searchSeat.getNumber() );
            currentSeat = currentSeat.getNext();
            size--;

            searchSeat = seatMap.get( noOfMoves++ );
//            System.out.println( "searchSeat = " + searchSeat );
        }

    }

    public void  checkAcross(){
        int noOfMoves = size / 2;
        searchSeat = currentSeat;
//        System.out.println( "searchSeat before= " + searchSeat );
        for (int i = 0; i < noOfMoves; i++) {
            searchSeat = searchSeat.next;
        }
//        System.out.println( "searchSeat = " + searchSeat );
        searchSeat.previous.joinNext( searchSeat.next );
        seatMap.remove( searchSeat.getNumber());
//        System.out.println( "map size = " + seatMap.size());
        currentSeat = currentSeat.getNext();
        size--;
//        System.out.println( "currentSeat = " + currentSeat );
//        System.out.println( "seatMap = " + seatMap );
    }

    public Seat getCurrentSeat() {
        return currentSeat;
    }

    public Map<Integer, Seat> getSeatMap() {
        return seatMap;
    }
}
