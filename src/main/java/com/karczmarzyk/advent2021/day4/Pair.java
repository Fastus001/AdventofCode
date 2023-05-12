package com.karczmarzyk.advent2021.day4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
class Pair {
    private int number;
    private boolean checked;


    @Override
    public String toString() {
        return checked ? number+"*": ""+number;
    }
}
