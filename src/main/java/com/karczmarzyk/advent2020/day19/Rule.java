package com.karczmarzyk.advent2020.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Rule {
    private static final Pattern NUM = Pattern.compile("(\\d+)");
    private boolean onlyLetters = false;
    private List<String> rulesA = new ArrayList<>();
    private List<String> rulesB = new ArrayList<>();

    public Rule(String in) {
        if (in.contains("|")) {
            String[] split = in.split("\\|");
            rulesA.add(split[0]);
            rulesB.add(split[1]);
        } else {
            rulesA.add(in);
        }
    }





}
