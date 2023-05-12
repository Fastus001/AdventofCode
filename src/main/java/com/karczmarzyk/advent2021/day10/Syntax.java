package com.karczmarzyk.advent2021.day10;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class Syntax {

    public boolean isLegal(String input) {
        return getIllegalCharacter(input).isEmpty();
    }

    public Optional<String> getIllegalCharacter(String input) {
        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '[' || c == '{' || c == '(' || c == '<') {
                chars.push(c);
            } else {
                char peek = chars.peek();
                if (isLegalCharacter(c, peek)) {
                    chars.pop();
                } else {
                    return Optional.of(String.valueOf(c));
                }
            }
        }
        return Optional.empty();
    }

    public String finishSequence(String input) {
        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '[' || c == '{' || c == '(' || c == '<') {
                chars.push(c);
            } else {
                char peek = chars.peek();
                if (isLegalCharacter(c, peek)) {
                    chars.pop();
                }
            }
        }
        var sb = new StringBuilder();
        while (!chars.isEmpty()) {
            Character pop = chars.pop();
            if (pop == '{') sb.append('}');
            else if (pop == '[') sb.append(']');
            else if (pop == '(') sb.append(')');
            else if (pop == '<') sb.append('>');
        }
        return sb.toString();
    }

    public Long calculateScore(String incomplete){
        return Arrays.stream(incomplete.split("")).mapToLong(this::convert)
                .reduce(0, (left, right) -> left*5+right);
    }

    private long convert(String c) {
        long number = 0;
        switch (c) {
            case ")" -> number = 1;
            case "]" -> number = 2;
            case "}" -> number = 3;
            case ">" -> number = 4;
        }
        return number;
    }

    private boolean isLegalCharacter(char c, char peek) {
        return (peek == '[' && c == ']') || (peek == '{' && c == '}') || (peek == '(' && c == ')') || (peek == '<' && c == '>');
    }
}
