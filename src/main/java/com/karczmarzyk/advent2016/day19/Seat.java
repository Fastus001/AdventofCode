package com.karczmarzyk.advent2016.day19;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private int number;
    public Seat previous;
    public Seat next;

    public Seat(int number) {
        this.number = number;
        previous = null;
        next = null;
    }

    public void joinPrevious(Seat seat){
        previous = seat;
        seat.next = this;
    }

    public void joinNext(Seat seat){
        next = seat;
        seat.previous = this;
    }

    @Override
    public String toString() {
        return "Seat{" + number +'}';
    }
}
