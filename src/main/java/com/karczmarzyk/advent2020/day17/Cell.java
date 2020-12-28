package com.karczmarzyk.advent2020.day17;

public class Cell {
    private Coordinates coordinates;
    private boolean active = false;

    public Cell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
