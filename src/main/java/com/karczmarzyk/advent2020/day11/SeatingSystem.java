package com.karczmarzyk.advent2020.day11;

public class SeatingSystem {
    private Seats seats;

    public SeatingSystem(Seats seats) {
        this.seats = seats;
    }

    public int transformGrid(){
        int count = seats.getOccupiedSeats();
        seats.setGrid( seats.getNewGrid() );
        int newNumber = seats.getOccupiedSeats();
        if(count!=newNumber)
            return transformGrid();
        else
            return newNumber;
    }
}
