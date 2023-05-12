package com.karczmarzyk.advent2021.day14;

import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class PolymerAdv {
    private String start;
    private Map<String, Long> pairs = new HashMap<>();
    private Map<String, Long> noOfChars;
    private List<PolymerTmplAdv> templates;

    public PolymerAdv(List<String> lines) {
        this.start = lines.get(0);
        templates = lines.stream().skip(2).map(s -> {
            String[] split = s.split(" -> ");
            return new PolymerTmplAdv(split[0],
                    List.of(split[0].charAt(0) + split[1], split[1] + split[0].charAt(1)),
                    split[1]);
        }).collect(Collectors.toList());
        noOfChars = Arrays.stream(start.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        initMove();
    }

    private void initMove() {
        List<String> insertions = new ArrayList<>();
        for (int i = 0; i < start.length() - 1; i++) {
            String substring = start.substring(i, i + 2);
            PolymerTmplAdv adv = templates.stream()
                    .filter(s -> s.pair().equals(substring))
                    .findFirst().get();
            insertions.addAll(adv.result());
            noOfChars.compute(adv.c(), (key, val) -> (val == null) ? 1 : val + 1);
        }
        pairs = insertions.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void step() {
        pairs.entrySet().forEach(this::addNewLetters);

        Map<String, Long> temp = new HashMap<>();
        for (var entry : pairs.entrySet()) {
            String entryKey = entry.getKey();
            PolymerTmplAdv adv = templates.stream()
                    .filter(s -> s.pair().equals(entryKey))
                    .findFirst().get();
            Long entryValue = entry.getValue();
            List<String> result = adv.result();
            result.forEach(s->{
                temp.compute(s, (k,v)-> (v == null) ? entryValue : v +entryValue);
            });

        }
        pairs = temp;
    }

    public Long calculateResult(){
        return noOfChars.values().stream().max(Long::compareTo).get() - noOfChars.values().stream().min(Long::compareTo).get();
    }

    private void addNewLetters(Map.Entry<String, Long> action){
        String key = action.getKey();
        PolymerTmplAdv adv = templates.stream()
                .filter(s -> s.pair().equals(key))
                .findFirst().get();
        noOfChars.compute(adv.c(), (k, val) -> (val == null) ? 1 : val + pairs.get(key));
    }

}
