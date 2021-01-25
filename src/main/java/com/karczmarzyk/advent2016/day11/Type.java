package com.karczmarzyk.advent2016.day11;

public enum Type {
    GENERATOR("G"),
    MICROCHIP("M");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
