package com.karczmarzyk.advent2016.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Chip implements Elevatorable, Cloneable{
    private String name;
    private Type type;
    private int floor;

    @Override
    public void moveUp() {
        floor++;
    }

    @Override
    public void moveDown() {
        floor--;
    }

    @Override
    protected Chip clone() {
        return Chip.builder()
                .type( type )
                .name( name )
                .floor( floor )
                .build();
    }
}
