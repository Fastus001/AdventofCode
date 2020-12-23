package com.karczmarzyk.advent2020.day15;

import java.util.HashMap;
import java.util.Map;

public class Recitation {
    private final Map<Integer, Number> map = new HashMap<>();
    private Number lastNumber;

    public Recitation(String input) {
        String[] split = input.split(",");
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            lastNumber = new Number(num,i+1);
            map.put(num,lastNumber);
        }
    }
    public void nextRound(){
        if(lastNumber.getTimesSpoken()==1){
            addZero(0);
        }else{
            int  number = lastNumber.getAge();
            addZero(number);
        }
    }

    private void addZero(int num){
        if(map.containsKey(num)){
            Number number = map.get(num);
            number.addTimesSpoken(lastNumber.getTurnNumberSecond()+1);
            lastNumber = number;
        }else{
            lastNumber = new Number(num, lastNumber.getTurnNumberSecond()+1);
            map.put(num,lastNumber);
        }
    }

    public Number getLastNumber() {
        return lastNumber;
    }
}
