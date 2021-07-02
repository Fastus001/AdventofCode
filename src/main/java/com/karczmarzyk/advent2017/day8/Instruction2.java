package com.karczmarzyk.advent2017.day8;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.valueOf;

@Data
public class Instruction2 {
    private final Map<String, Integer> registers = new HashMap<>();
    private final List<String> instructionsList;
    private Integer max = 0;

    public Instruction2(List<String> input) {
        this.instructionsList = input;
        input.forEach(s -> registers.put(s.split(" ")[0], 0));
    }

    public int start(){
        instructionsList.stream()
                .map(s -> s.split(" if "))
                .forEach(strings -> {
                    if(condition(strings[1])){
                        executeInstruction(strings[0]);
                    }
                    checkMax();
                });

        return registers.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(-1);
    }

    private void checkMax(){
        Integer maxAfterIteration = registers.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(-1);
        if(maxAfterIteration>max){
            max = maxAfterIteration;
        }
    }

    public void executeInstruction(String instr){
        String[] array = instr.split(" ");
        String key = array[0];
        String operation = array[1];
        Integer value = valueOf(array[2]);
        int i = 0;
        if(operation.equals("inc")){
            i = registers.get(key) + value;
        }
        if(operation.equals("dec")){
            i = registers.get(key) - value;
        }
        registers.put(key, i);
    }

    public boolean condition(String condition) {
        String[] split = condition.split(" ");
        Integer value = valueOf(split[2]);
        Integer register = registers.get(split[0]);

        switch (split[1]){
            case "==": return register.equals(value);
            case "!=": return !register.equals(value);
            case ">=": return register >= value;
            case "<=": return register <= value;
            case ">": return register > value;
            case "<": return register < value;
            default: return false;
        }
    }
}
