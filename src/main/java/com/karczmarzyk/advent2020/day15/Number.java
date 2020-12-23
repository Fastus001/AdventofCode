package com.karczmarzyk.advent2020.day15;

public class Number {
    private int number;
    private int timesSpoken;
    private int turnNumberSecond;
    private int turnNumberFirst = 0;

    public Number(int number,int turnNumber) {
        this.number = number;
        this.turnNumberSecond = turnNumber;
        timesSpoken = 1;
    }

    public int getNumber() {
        return number;
    }

    public void addTimesSpoken(int turn){
        turnNumberFirst = turnNumberSecond;
        turnNumberSecond = turn;
        timesSpoken++;
    }

    public int getAge(){
        return turnNumberSecond-turnNumberFirst;
    }

    public int getTimesSpoken() {
        return timesSpoken;
    }

    public int getTurnNumberFirst() {
        return turnNumberFirst;
    }

    public int getTurnNumberSecond() {
        return turnNumberSecond;
    }
}
