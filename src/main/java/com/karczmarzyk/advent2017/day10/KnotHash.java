package com.karczmarzyk.advent2017.day10;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Data
public class KnotHash {
    private int currentPosition = 0;
    private int skipSize = 0;
    private List<Integer> numbers;

    public KnotHash(int size) {
        numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
    }

    public int start(int... ints) {
        for (int anInt : ints) {
            reverseSublist(anInt);
        }
        return numbers.get(0) * numbers.get(1);
    }

    public void reverseSublist(int length) {
        List<Integer> temp = getSubList(length);
        Collections.reverse(temp);
        resetSublistToNumbers(length, temp);
        currentPosition = (currentPosition + length + skipSize) % numbers.size();
        skipSize++;
    }

    private void resetSublistToNumbers(int length, List<Integer> temp) {
        for (int i = currentPosition, k = 0; k < length; i++, k++) {
            if (i >= numbers.size()) {
                i = 0;
            }
            numbers.set(i, temp.get(k));
        }
    }

    @NotNull
    private List<Integer> getSubList(int length) {
        List<Integer> temp = new ArrayList<>();
        for (int i = currentPosition, k = 0; k < length; i++, k++) {
            if (i >= numbers.size()) {
                i = 0;
            }
            temp.add(numbers.get(i));
        }
        return temp;
    }
}
