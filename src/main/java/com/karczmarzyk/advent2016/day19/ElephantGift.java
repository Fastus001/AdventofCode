package com.karczmarzyk.advent2016.day19;

import java.util.Iterator;
import java.util.LinkedList;

public class ElephantGift {
    private final LinkedList<Integer> seats;
    private boolean keep = true;

    public ElephantGift(int size) {
        seats = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            seats.add( i );
        }
    }

    public int removeSeats(){
        Iterator<Integer> iterator = seats.listIterator(0);
        while (iterator.hasNext()){
            if(keep){
                iterator.next();
                keep = false;
            }else {
                iterator.next();
                iterator.remove();
                keep = true;
            }
        }
        if(seats.size()>1){
            return removeSeats();
        }else{
            return seats.getFirst();
        }
    }
}
