package com.karczmarzyk.advent2017.day13;

import lombok.Data;

@Data
public class Layer {
    private final int size;
    private Direction direction = Direction.UP;
    private int position = 1;

    public Layer(int size) {
        this.size = size;
    }

    public void move() {
        position += direction.step;
        if(position == size) {
            direction = Direction.DOWN;
        }
        if (position == 1) {
            direction = Direction.UP;
        }
    }

    public int getSeverity(int i) {
        return i*size;
    }
}
