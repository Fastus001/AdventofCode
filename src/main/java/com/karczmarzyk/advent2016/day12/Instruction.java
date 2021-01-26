package com.karczmarzyk.advent2016.day12;


import lombok.Getter;

@Getter
public class Instruction {
    private final String code;
    private final String first;
    private final String second;

    public Instruction(String input) {
        String[] s = input.split( " " );
        code = s[0];
        first = s[1];
        second = s.length > 2 ? s[2] : null;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "code='" + code + '\'' +
                ", first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
