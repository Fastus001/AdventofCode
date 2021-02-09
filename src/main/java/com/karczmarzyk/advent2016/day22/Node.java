package com.karczmarzyk.advent2016.day22;

import lombok.Builder;
import lombok.Data;

@Data
public class Node {
    private int x;
    private int y;
    private int size;
    private int used;
    private int avail;

    @Builder
    public Node(int x, int y, int size, int used, int avail) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.used = used;
        this.avail = avail;
    }

    @Override
    public String toString() {
        return "("+ size+"/"+used +
                "/" + avail+')';
    }
}
