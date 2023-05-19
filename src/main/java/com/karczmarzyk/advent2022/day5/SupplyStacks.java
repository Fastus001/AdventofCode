package com.karczmarzyk.advent2022.day5;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SupplyStacks {

    private final List<Stack<String>> stacks;

    public SupplyStacks(List<List<String>> input) {
        this.stacks = input.stream().map(lst -> {
            var stack = new Stack<String>();
            lst.forEach(stack::push);
            return stack;
        }).collect(toList());
    }


    public String getTop() {
        return stacks.stream().map(Stack::peek)
                .collect(Collectors.joining());
    }

    public String moveAllCrates(List<String> procedures){
        procedures.forEach(this::craneMove);

        return getTop();
    }

    private void craneMove(String procedure){
        final String[] splits = procedure.split(" ");
        //input counts from 1...
        int crateToMove = Integer.parseInt(splits[1]);
        int from = Integer.parseInt(splits[3]) - 1;
        int to = Integer.parseInt(splits[5]) - 1;

        for (int i = 0; i < crateToMove; i++) {
            final String crate = stacks.get(from).pop();
            stacks.get(to).push(crate);
        }
    }
}
