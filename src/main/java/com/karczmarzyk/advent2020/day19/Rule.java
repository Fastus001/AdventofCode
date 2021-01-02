package com.karczmarzyk.advent2020.day19;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Rule {
    private static final Pattern NUM = Pattern.compile("(\\d+)");
    private boolean onlyLetters = false;
    private List<String> rulesA = new ArrayList<>();
    private List<String> rulesB = new ArrayList<>();
    private List<String> rulesFinal = new ArrayList<>();

    public Rule(String in) {
        String s = in.replaceAll("72", "b").replaceAll("52", "a");
//        String s = in;
        if (s.contains("|")) {
            String[] split = s.split("\\|");
            rulesA.add(split[0]);
            rulesB.add(split[1] + " ");
        } else {
            rulesA.add(s + " ");
        }
        if (isRulesOnlyLetters()) {
            onlyLetters = true;
            combineRules();
        }
    }

    public void addNewRules(List<String> list, String num) {

        rulesA = replaceRulesList(list, num, rulesA);
        rulesB = replaceRulesList(list, num, rulesB);
        boolean check = isRulesOnlyLetters();
        if (check) {
            onlyLetters = true;
            combineRules();
        }
    }

    private List<String> replaceRulesList(List<String> list, String num, List<String> rulesAB) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < rulesAB.size(); i++) {
            if (rulesAB.get(i).contains(num)) {
                for (String l : list) {
                    temp.add(rulesAB.get(i).replaceAll(num, " " + l + " "));
                }
            }
        }
        return temp.size() == 0 ? rulesAB : temp;
    }

    private void combineRules() {
        rulesFinal.addAll(rulesA);
        rulesFinal.addAll(rulesB);
        rulesFinal = rulesFinal.stream()
                .map(s -> s.replaceAll(" ", ""))
                .collect(Collectors.toList());
    }

    private boolean isRulesOnlyLetters() {
        for (String s : rulesA) {
            if (haveNumbers(s)) {
                return false;
            }
        }
        for (String s : rulesB) {
            if (haveNumbers(s)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumber() {
        List<Integer> temp = new ArrayList<>();
        getNumberFromRules(temp, rulesA);
        getNumberFromRules(temp, rulesB);
//        System.out.println("temp = " + temp);
        return temp;
    }

    private void getNumberFromRules(List<Integer> temp, List<String> rules) {
        String s1 = String.join("", rules);
        temp.addAll(NUM.matcher(s1).results()
                .map(MatchResult::group)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }

    public boolean isOnlyLetters() {
        return onlyLetters;
    }

    public boolean haveNumbers(String s) {
        return NUM.matcher(s).find();
    }


    public List<String> getRulesFinalRules() {
        return rulesFinal;
    }

    public List<String> getRules() {
        List<String> temp = new ArrayList<>();
        temp.addAll(rulesA);
        temp.addAll(rulesB);
        return temp;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "Letters=" + onlyLetters +
                "  final" + rulesFinal +
                "     " +getRules() +
                '}';
    }
}
