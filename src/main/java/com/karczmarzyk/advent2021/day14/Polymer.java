package com.karczmarzyk.advent2021.day14;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Polymer {
    private String polymer;
    private List<PolymerTemplate> templates;
    private List<Insertion> insertions = new ArrayList<>();

    public Polymer(List<String> lines) {
        this.polymer = lines.get(0);
        templates = lines.stream().skip(2).map(s -> {
            String[] split = s.split(" -> ");
            return new PolymerTemplate(split[0], split[1]);
        }).collect(Collectors.toList());
    }

    public String transfer() {
        for (int i = 0; i < polymer.length()-1; i++) {
            String substring = polymer.substring(i, i + 2);
            int finalI = i;
            insertions.addAll(
                    templates.stream().filter(s -> s.pair().equals(substring)).map(PolymerTemplate::insert)
                            .map(s -> new Insertion(finalI, s)).toList()
            );
        }

        var sb = new StringBuilder(polymer);
        int offset = 1;
        for (Insertion ins: insertions) {
            sb.insert(offset+ins.pos, ins.c);
            offset++;
        }
        polymer = sb.toString();
        insertions.clear();
        return sb.toString();
    }

    public int calculateResult(){
        List<Insertion> collect = Arrays.stream(polymer.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().map(e -> new Insertion(e.getValue().intValue(), e.getKey())).sorted().toList();
        Insertion min = collect.get(0);
        Insertion max = collect.get(collect.size()-1);
        return max.pos- min.pos();
    }

    record Insertion(int pos, String c) implements Comparable<Insertion> {
        @Override
        public int compareTo(@NotNull Insertion o) {
            return Integer.compare(this.pos, o.pos);
        }
    }
}
