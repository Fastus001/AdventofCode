package com.karczmarzyk.advent2020.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemAddress {

    private final Decoder decoder = new Decoder("");
    private final Map<String,Long> integerMap = new HashMap<>();

    public void setDecoderMask(String  mask) {
        decoder.setMask(mask);
    }

    public void addToMemory(int... line){
        final List<String> floating = decoder
                                        .getFloating(List.of(decoder.convertNumberToBitString(line[0])));
        for(String s:floating){
            integerMap.put(s,(long)line[1]);
        }
    }

    public long getSumOfMem(){
        return integerMap.values()
                .stream()
                .reduce(Long::sum)
                .orElseThrow();
    }
}
