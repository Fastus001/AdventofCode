package com.karczmarzyk.advent2016.day10;

import lombok.Getter;

import java.util.Set;
import java.util.TreeSet;

@Getter
public class Bot {
    private final String  name;
    private final String low;
    private final String high;
    private final Set<Integer> values = new TreeSet<>();
    private boolean bothValues = false;

    public Bot(String name, String low, String high) {
        this.name = name;
        this.low = low;
        this.high = high;
    }

    public boolean addValue(int value){
        values.add( value );
        if(values.size()==2){
            bothValues=true;
            return true;
        }
        return false;
    }

    public int getValue(boolean low){
        if(low){
            return values.stream()
                    .min( Integer::compareTo )
                    .orElseThrow();
        }else{
            return values.stream()
                    .max( Integer::compareTo )
                    .orElseThrow();
        }
    }

    public Set<Integer> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                ", low='" + low + '\'' +
                ", high='" + high + '\'' +
                ", values=" + values +
                ", bothValues=" + bothValues +
                '}';
    }
}
