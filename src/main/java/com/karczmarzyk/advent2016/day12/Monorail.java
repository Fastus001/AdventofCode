package com.karczmarzyk.advent2016.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Monorail {
    private List<Instruction> instructions = new ArrayList<>();
    private Map<String, Integer> registers = new HashMap<>();
    private static int currentIndex = 0;

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

    public int executeInstruction(Instruction instruction) {
        switch (instruction.getCode()) {
            case "inc":
                Integer value = registers.get( instruction.getFirst() );
                registers.put( instruction.getFirst(), value + 1 );
                return 1;

            case "dec":
                Integer decVal = registers.get( instruction.getFirst() );
                registers.put( instruction.getFirst(), decVal - 1 );
                return 1;

            case "cpy":
                String first = instruction.getFirst();
                Integer integer = registers.get( first );
                if ( integer == null ) {
                    registers.put( instruction.getSecond(), Integer.parseInt( first ) );
                }
                else {
                    registers.put( instruction.getSecond(), registers.get( first ) );
                }
                return 1;

            case "jnz":
                Integer registryValue = registers.get( instruction.getFirst() );
                if(registryValue==null){
                    int i = Integer.parseInt( instruction.getFirst() );
                    if(i==0){
                        return 1;
                    }else{
                        return Integer.parseInt( instruction.getSecond() );
                    }
                }else{
                    if ( registryValue.equals( 0 ) ) {
                        return 1;
                    }
                    else {
                        return Integer.parseInt( instruction.getSecond() );
                    }
                }
        }
        return 0;
    }

    public void setInstructions(List<String> lines) {
        this.instructions = lines.stream()
                .map( Instruction::new )
                .collect( Collectors.toList());;
    }

    public Map<String, Integer> getRegisters() {
        return registers;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }
}
