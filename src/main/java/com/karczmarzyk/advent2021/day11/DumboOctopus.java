package com.karczmarzyk.advent2021.day11;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DumboOctopus {
    private List<List<Integer>> octopuses;
    public int counter = 0;

    public DumboOctopus(List<String> input) {
        this.octopuses = input.stream()
                .map(s -> Arrays.stream(s.split("")).map(Integer::parseInt).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public int round() {
        int startFlashes = counter;
        //first step increase level by one
        increaseByOne();
        //flash
        flash();
        return counter - startFlashes;
    }

    private void flash() {
        for (int y = 0; y < octopuses.size(); y++) {
            for (int x = 0; x < octopuses.get(0).size(); x++) {
                if (octopuses.get(y).get(x) > 9)
                    flash(y, x);
            }
        }
    }

    private void flash(int y, int x) {
        counter++;
        octopuses.get(y).set(x, 0);
        increaseByOne(y - 1, x - 1);
        increaseByOne(y - 1, x);
        increaseByOne(y - 1, x + 1);
        increaseByOne(y, x - 1);
        increaseByOne(y, x + 1);
        increaseByOne(y + 1, x - 1);
        increaseByOne(y + 1, x);
        increaseByOne(y + 1, x + 1);
    }

    private void increaseByOne(int y, int x) {
        if (y < 0 || x < 0 || y >= octopuses.size() || x >= octopuses.size()) {
            return;
        } else {
            Integer value = octopuses.get(y).get(x);
//            System.out.println("value = " + value);
            if (value.equals(0)) return;
            else if (value < 9) {
                octopuses.get(y).set(x, value+1);
            } else {
                flash(y, x);
            }
        }
    }

    private void increaseByOne() {
        octopuses = octopuses.stream().map(l -> l.stream().map(i -> i + 1).collect(Collectors.toList())).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return octopuses.stream().map(l -> l.stream().map(Object::toString).collect(Collectors.joining(" "))).collect(Collectors.joining("\n")) + "\n\n";
    }
}
