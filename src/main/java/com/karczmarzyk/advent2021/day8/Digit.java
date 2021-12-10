package com.karczmarzyk.advent2021.day8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Digit {
    private final Map<String, String> digits = new HashMap<>();
    private List<String> toGuess;
    private final List<String> numbers;
    private String one;
    private String seven;
    private String four;

    public Digit(String input) {
        String[] split = input.split(" \\| ");
        toGuess = Arrays.stream(split[0].split(" ")).map(this::sort).collect(Collectors.toList());
        numbers = Arrays.stream(split[1].split(" ")).map(this::sort).collect(Collectors.toList());

    }

    public long getNumber(){
        filterKnowNumber();
        filterNine();
        filterThree();
        filterZeroAndSix();
        filterTwoAndFive();
        return Long.parseLong(numbers.stream().map(s->digits.get(s)).collect(Collectors.joining()));
    }

    private void filterKnowNumber() {
        one = toGuess.stream().filter(s -> s.length() == 2).findFirst().get();
        digits.put(one, "1");
        seven = toGuess.stream().filter(s -> s.length() == 3).findFirst().get();
        digits.put(seven, "7");
        four = toGuess.stream().filter(s -> s.length() == 4).findFirst().get();
        digits.put(four, "4");
        String eight = toGuess.stream().filter(s -> s.length() == 7).findFirst().get();
        digits.put(eight, "8");
        Set<String> keySet = digits.keySet();
        toGuess = toGuess.stream().filter(s -> !keySet.contains(s)).collect(Collectors.toList());
    }

    private void filterNine() {
        String nine = toGuess.stream().filter(s->s.length()==6)
                .filter(s -> containAllChars(s, one) && containAllChars(s, seven) && containAllChars(s, four))
                .findFirst().get();
        digits.put(nine, "9");
        Set<String> keySet = digits.keySet();
        toGuess = toGuess.stream().filter(s -> !keySet.contains(s)).collect(Collectors.toList());
    }

    private void filterThree() {
        String three = toGuess.stream().filter(s->s.length()==5)
                .filter(s -> containAllChars(s, one) && containAllChars(s, seven))
                .findFirst().get();
        digits.put(three, "3");
        Set<String> keySet = digits.keySet();
        toGuess = toGuess.stream().filter(s -> !keySet.contains(s)).collect(Collectors.toList());
    }

    private void filterZeroAndSix() {
        List<String> zeroSix = toGuess.stream().filter(s -> s.length() == 6).toList();
        for (String s : zeroSix) {
            if(containAllChars(s, one) && containAllChars(s, seven)){
                digits.put(s, "0");
            }else {
                digits.put(s, "6");
            }
        }
        Set<String> keySet = digits.keySet();
        toGuess = toGuess.stream().filter(s -> !keySet.contains(s)).collect(Collectors.toList());
    }

    private void filterTwoAndFive() {
        String nine = digits.entrySet().stream().filter(e -> e.getValue().equals("9"))
                .map(e -> e.getKey()).findFirst().get();
        for (String s : toGuess) {
            if(containAllChars(nine, s)){
                digits.put(s, "5");
            }else {
                digits.put(s, "2");
            }
        }
        Set<String> keySet = digits.keySet();
        toGuess = toGuess.stream().filter(s -> !keySet.contains(s)).collect(Collectors.toList());
    }

    public boolean containAllChars(String first, String second) {
        return Arrays.stream(second.split("")).map(first::contains)
                .filter(b -> b.equals(Boolean.FALSE))
                .findFirst().orElse(true);
    }

    private String sort(String word) {
        return Arrays.stream(word.split("")).sorted().collect(Collectors.joining());
    }

    public <K, V> Stream<K> keys(Map<K, V> map, V value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }
}
