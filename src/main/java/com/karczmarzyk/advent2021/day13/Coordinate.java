package com.karczmarzyk.advent2021.day13;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Coordinate implements Comparable<Coordinate>{
    private int x;
    private int y;

    public Coordinate(String line) {
        String[] split = line.split(",");
        this.x = Integer.parseInt(split[0]);
        this.y = Integer.parseInt(split[1]);
    }


    @Override
    public int compareTo(@NotNull Coordinate o) {
        return Integer.compare(this.x, o.x);
    }
}
