package com.karczmarzyk.advent2016.day19;

import lombok.Data;

@Data
public class Seat {
    private int number;
    private Seat previous;
    private Seat next;

    public void joinNext(Seat next){
        this.next = next;
        next.setPrevious( this );
    }

    public void joinPrevious(Seat previous){
        this.previous = previous;
        previous.next = this;
    }
}
