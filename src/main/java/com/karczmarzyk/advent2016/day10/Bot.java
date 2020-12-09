package com.karczmarzyk.advent2016.day10;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    private final List<Integer> values= new ArrayList<>();
    private final int lowOutput;
    private final int highOutput;

    public Bot(int lowOutput, int highOutput) {
        this.lowOutput = lowOutput;
        this.highOutput = highOutput;
    }

    public boolean addValue(int value){
        values.add( value );
        return values.size()==2;
    }

    public int getMinValue(){
        return values.stream()
                .min( Integer::compareTo )
                .orElseThrow();
    }

    public int getMaxValue(){
        return values.stream()
                .max( Integer::compareTo )
                .orElseThrow();
    }

    public int getLowOutput() {
        return lowOutput;
    }

    public int getHighOutput() {
        return highOutput;
    }
}
