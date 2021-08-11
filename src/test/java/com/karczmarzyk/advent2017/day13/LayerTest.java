package com.karczmarzyk.advent2017.day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LayerTest {

    @Test
    void move() {
        Layer layer = new Layer(3);
        for (int i = 0; i < 8; i++) {
            layer.move();
        }

        int position = layer.getPosition();

        assertEquals(1, position);
    }
}
