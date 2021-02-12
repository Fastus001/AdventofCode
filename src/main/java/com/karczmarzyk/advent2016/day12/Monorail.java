package com.karczmarzyk.advent2016.day12;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class Monorail {
    private List<Instruction> instructions = new ArrayList<>();
    private final Map<String, Integer> registers = new HashMap<>();
    private int currentIndex = 0;
    private final List<Integer> results = new ArrayList<>();

    public Monorail() {
        registers.put( "a", 0 );
        registers.put( "b", 0 );
        registers.put( "c", 0 );
        registers.put( "d", 0 );
    }

    public int start() {
        currentIndex += executeInstruction( instructions.get( currentIndex ) );
        return registers.get( "a" );
    }

    public void setAndReset(int a) {
        registers.put( "a", a );
//        registers.put( "b", 0 );
//        registers.put( "c", 0 );
//        registers.put( "d", 0 );
        currentIndex = 0;
        results.clear();
    }

    public int getSizeOfResult() {
        return results.size();
    }

    public boolean isResultsOk() {
        for (int i = 0; i < results.size(); i++) {
            if ( i % 2 == 1 ) {
                if ( results.get( i ) == 0 ) {
                    return false;
                }
            }
            if ( i % 2 == 0 ) {
                if ( results.get( i ) == 1 ) {
                    return false;
                }
            }
        }
        return true;
    }

    public int executeInstruction(Instruction instruction) {
        switch (instruction.getCode()) {
            case "out":
//                System.out.println(registers.get( instruction.getFirst() ));
                results.add( registers.get( instruction.getFirst() ) );
                System.out.println( "registers = " + registers );
                return 1;
            case "inc":
                Integer value = registers.get( instruction.getFirst() );
                registers.put( instruction.getFirst(), value+1 );
                return 1;

            case "dec":
                Integer decVal = registers.get( instruction.getFirst() );
                registers.put( instruction.getFirst(), decVal - 1 );
                return 1;

            case "cpy":
                String second = instruction.getSecond();
                if ( second.matches( "[abcd]" ) ) {
                    String first = instruction.getFirst();
                    Integer integer = registers.get( first );
                    if ( integer == null ) {
                        registers.put( instruction.getSecond(), Integer.parseInt( first ) );
                    }
                    else {
                        registers.put( instruction.getSecond(), registers.get( first ) );
                    }
                }
                return 1;

            case "jnz":
                Integer registryValue = registers.get( instruction.getFirst() );
                if ( registryValue == null ) {
                    int i = Integer.parseInt( instruction.getFirst() );
                    if ( i == 0 ) {
                        return 1;
                    }
                    else {
                        if ( instruction.getSecond().matches( "[abcd]" ) ) {
                            return registers.get( instruction.getSecond() );
                        }
                        else {
                            return Integer.parseInt( instruction.getSecond() );
                        }
                    }
                }
                else {
                    if ( registryValue.equals( 0 ) ) {
                        return 1;
                    }
                    else {
                        return Integer.parseInt( instruction.getSecond() );
                    }
                }
            case "tgl":
                Integer regValue = registers.get( instruction.getFirst() );
                if ( regValue + currentIndex >= 0 && regValue + currentIndex < instructions.size() ) {
                    Instruction instrToToggle = instructions.get( regValue + currentIndex );
                    switch (instrToToggle.getCode()) {
                        case "inc":
                            instrToToggle.setCode( "dec" );
                            return 1;
                        case "dec":
                        case "tgl":
                            instrToToggle.setCode( "inc" );
                            return 1;
                        case "jnz":
                            instrToToggle.setCode( "cpy" );
                            return 1;
                        case "cpy":
                            instrToToggle.setCode( "jnz" );
                            return 1;
                    }
                }
        }
        return 1;
    }

    public void setInstructions(List<String> lines) {
        this.instructions = lines.stream()
                .map( Instruction::new )
                .collect( Collectors.toList() );
        ;
    }

    public Map<String, Integer> getRegisters() {
        return registers;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
