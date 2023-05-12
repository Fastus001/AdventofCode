package com.karczmarzyk.advent2021.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SyntaxUtil {
    private List<String> uncompleted;
    private List<String> completions= new ArrayList<>();

    public long setUncompletedSyntax(List<String> input){
        Syntax syntax = new Syntax();
        uncompleted = input.stream().filter(syntax::isLegal)
                .collect(Collectors.toList());
        completions = uncompleted.stream().map(syntax::finishSequence).collect(Collectors.toList());
        List<Long> collect = completions.stream().map(syntax::calculateScore).sorted().collect(Collectors.toList());
        return collect.get(collect.size()/2);
    }
}
