package com.karczmarzyk.advent2020.day13;

public class Bus {
    private int id;
    private int offset;

    public Bus(int id, int offset) {
        this.id = id;
        this.offset = offset;
    }

    public int getIdByOffset(){
        return id-offset;
    }

    public int getId() {
        return id;
    }

    public int getOffset() {
        return offset;
    }
}
