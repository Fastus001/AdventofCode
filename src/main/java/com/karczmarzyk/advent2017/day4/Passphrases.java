package com.karczmarzyk.advent2017.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Passphrases {

    public long numberOfValidPhrases(List<String> phrases){
        return phrases.stream()
                        .filter(this::isPhraseValid)
                        .count();
    }

    public boolean isPhraseValid(String phrase){
        List<String> phrases = Arrays.stream(phrase.split(" "))
                .collect(Collectors.toList());
        int numberOfPhrases = phrases.size();
        int numberOfDistinctPhrases = (int) phrases.stream()
                .distinct().count();
        return numberOfPhrases == numberOfDistinctPhrases;
    }

    public long numberOfValidPhrasesPartTwo(List<String> phrases) {
        return phrases.stream()
                .map(this::sortPhrases)
                .filter(this::isPhraseValidTwo)
                .count();
    }

    public boolean isPhraseValidTwo(List<String> phrases){
        int numberOfPhrases = phrases.size();
        int numberOfDistinctPhrases = (int) phrases.stream()
                .distinct().count();
        return numberOfPhrases == numberOfDistinctPhrases;
    }

    private List<String> sortPhrases(String line){
        return Arrays.stream(line.split(" "))
                .map(this::sortString)
                .collect(Collectors.toList());
    }

    private String sortString(String word) {
        char[] array = word.toCharArray();
        Arrays.sort(array);

        return new String(array);
    }
}
