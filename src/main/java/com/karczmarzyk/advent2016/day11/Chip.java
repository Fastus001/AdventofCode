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

    protected Chip cloneChip() throws CloneNotSupportedException {
        return (Chip ) clone();
    }

    @Override
    public String toString() {
        return name.substring( 0,2 ) + type.getName() +"," + floor;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Chip chip = ( Chip ) o;

        if ( floor != chip.floor ) return false;
        if ( name != null ? !name.equals( chip.name ) : chip.name != null ) return false;
        return type == chip.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + floor;
        return result;
    }
}
