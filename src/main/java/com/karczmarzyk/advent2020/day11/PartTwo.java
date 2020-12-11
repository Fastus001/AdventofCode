package com.karczmarzyk.advent2020.day11;

public class PartTwo {
    private SeatsAdv seatsAdv;

    public PartTwo(SeatsAdv seatsAdv) {
        this.seatsAdv = seatsAdv;
    }

    public int transformGrid(){
        int count = seatsAdv.getOccupiedSeats();
        seatsAdv.setGrid( seatsAdv.getNewGrid() );
        int newNumber = seatsAdv.getOccupiedSeats();
        if(count!=newNumber)
            return transformGrid();
        else
            return newNumber;
    }
}
