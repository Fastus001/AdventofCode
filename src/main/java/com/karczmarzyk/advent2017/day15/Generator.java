package com.karczmarzyk.advent2017.day15;

import lombok.Data;


@Data
public class Generator {
    private final static long DIVIDER = 2147483647;
    private long factor;
    private long previousValue;
    private int criteria;

    public Generator(long factor, long initValue) {
        this.factor = factor;
        this.previousValue = (initValue * this.factor) % DIVIDER;
    }

    public String onNext() {
        final String returnValue = Long.toString(previousValue,2);
        this.previousValue = (previousValue*factor) % DIVIDER;

        return returnValue;
    }

    public String onNextValue() {
        boolean check = false;
        final String returnValue = Long.toString(previousValue,2);
        if(previousValue % criteria == 0) {
            check = true;
        }
        this.previousValue = (previousValue*factor) % DIVIDER;
        return check ? returnValue : onNextValue();
    }

}
