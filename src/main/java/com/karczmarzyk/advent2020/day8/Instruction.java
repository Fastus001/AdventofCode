package com.karczmarzyk.advent2020.day8;

public class Instruction {
    private static int accumulator = 0;
    private String operation;
    private int argument;
    private boolean visited = false;

    public Instruction(String operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public int executeInstruction() {
        if ( operation.equals( "acc" ) ) {
            accumulator += argument;
            visited = true;
            return 1;
        }
        else if ( operation.equals( "jmp" ) ) {
            visited = true;
            return argument;
        }
        else{
            visited = true;
            return 1;
        }
    }

    public int getAccumulator() {
        return accumulator;
    }

    public boolean isVisited()
    {
        return visited;
    }
}
