package com.karczmarzyk.advent2016.day19;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class GiftAcross {
    private final Map<Integer,Seat> seatMap = new HashMap<>();
    private Seat currentSeat;
    private Seat searchSeat;

    public GiftAcross(int size) {
        for (int i = 1; i <=size ; i++) {
            seatMap.put( i,new Seat( i ) );
        }
        seatMap.forEach( linkSeats() );
        seatMap.get( 1 ).joinPrevious( seatMap.get( size ) );
        currentSeat = seatMap.get( 1 );
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
        searchSeat = seatMap.get( (seatMap.size() / 2));
        boolean even = (seatMap.size()) % 2 == 0;
        while (seatMap.size()>1){
            removeItemAcross();
            if(!even) {
                moveToNext();
            }
            removeItemAcross();
            if(even) {
                moveToNext();
            }
        }
    }

    private void removeFromMap() {
        searchSeat.previous.joinNext( searchSeat.next );
        seatMap.remove( searchSeat.getNumber() );
        currentSeat = currentSeat.getNext();
    }

    private void removeItemAcross() {
        moveToNext();
        removeFromMap();
    }

    private void moveToNext() {
        searchSeat = seatMap.get( searchSeat.next.getNumber() );
    }

    public Seat getCurrentSeat() {
        return currentSeat;
    }

    public Map<Integer, Seat> getSeatMap() {
        return seatMap;
    }
}
