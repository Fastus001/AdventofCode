package com.karczmarzyk.advent2021.day12;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cave {
    private String name;
    private Size size;
    private List<String> connections = new ArrayList<>();

    public Cave(String name, Size size, String connection) {
        this.name = name;
        this.size = size;
        this.connections.add(connection);
    }

    public void addConnection(String connection){
        connections.add(connection);
    }

    enum Size{
        SMALL,BIG
    }
}
