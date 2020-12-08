package com.karczmarzyk.advent2020.day8;

public class Instruction {
    private static int accumulator = 0;
    private String operation;
    private final int argument;
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

    public static int getAccumulator() {
        return accumulator;
    }

    public boolean isVisited()
    {
        return visited;
    }

    public static void setAccumulator(int accumulator) {
        Instruction.accumulator = accumulator;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void swap() {
        if(operation.equals( "jmp" )){
            operation ="nop";
        }else if(operation.equals( "nop" )){
            operation = "jmp";
        }
    }

}
